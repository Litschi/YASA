TASK(BT_IMPLIZIT_SLAVE)
{
	#ifdef __DEBUG__
		display_goto_xy(0,0);
		display_string("BT MASTER");
		display_update();
	#endif
	
	while(ecrobot_get_bt_status()!=BT_STREAM)
	{
		#ifdef __DEBUG__
		display_goto_xy(0,1);
		display_int(ecrobot_get_bt_status(), 0);
		display_update();
		#endif
		ecrobot_init_bt_slave("YASA");
	}

	while(1)
	{
		WaitEvent(BT_SEND_MY_MESSAGE);
		ClearEvent(BT_SEND_MY_MESSAGE);
		ecrobot_send_bt_packet(&BT_transmit_package, BT_PACKAGE_SIZE);
	}
	TerminateTask();
}

//pullt ständig aufm BT
//hat relativ niedirge prio
TASK(BT_IMPLIZIT_SLAVE2)
{
	U8 lastValue[BT_PACKAGE_SIZE];
	while(1)
	{
		if(ecrobot_read_bt_packet(&lastValue, BT_PACKAGE_SIZE) > 0)
		{
			strcpy(BT_receive_package, lastValue);
			SetEvent(TASK_BT_INTERFACE_READER, BT_HAS_RECEIVED_PACKAGE);
		}
	}
	TerminateTask();
}
#define BT_COM_SERVICE 1

#define BT_DYNAMIC_READER_CODE ( switch(id){})
#define BT_DYNAMIC_WRITER_CODE (WaitEvent(RTE_Schussanlage_Trigger_GetValue_Event_In_EVENT );GetEvent(TASK_BT_INTERFACE_WRITER, &event);if(event & RTE_Schussanlage_Trigger_GetValue_Event_In_EVENT){ClearEvent(RTE_Schussanlage_Trigger_GetValue_Event_In_EVENT);*transmit_pack_ptr = 0;transmit_pack_ptr++;strcpy(BT_transmit_package, COMSERVICE_transmit_package[0]);SetEvent(BT_IMPLIZIT_SLAVE,BT_SEND_MY_MESSAGE);})

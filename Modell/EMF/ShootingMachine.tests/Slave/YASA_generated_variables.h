#define BT_COM_SERVICE 2

#define BT_DYNAMIC_READER_CODE switch(id){case null:strcpy(COMSERVICE_receive_package[null], locBuffer_ptr);SetEvent(SchussanlagenTask,RTE_Schussanlage_StopSensor_GetValue_Event_In_EVENT);break;case 3:strcpy(COMSERVICE_receive_package[3], locBuffer_ptr);SetEvent(Trigger,RTE_Trigger_GetValue_Receiver_In_EVENT);break;case null:strcpy(COMSERVICE_receive_package[null], locBuffer_ptr);SetEvent(Output,RTE_Output_GetValue_Receiver_In_EVENT);break;}
#define BT_DYNAMIC_WRITER_CODE WaitEvent(RTE_Schussanlage_Trigger_GetValue_Event_In_EVENT | WaitEvent(RTE_Trigger_StartTrigger_GetValue_Event_In_EVENT );GetEvent(TASK_BT_INTERFACE_WRITER, &event);if(event & RTE_Schussanlage_Trigger_GetValue_Event_In_EVENT){ClearEvent(RTE_Schussanlage_Trigger_GetValue_Event_In_EVENT);*transmit_pack_ptr = 0;transmit_pack_ptr++;strcpy(BT_transmit_package, COMSERVICE_transmit_package[0]);SetEvent(BT_IMPLIZIT_SLAVE,BT_SEND_MY_MESSAGE);}if(event & RTE_Trigger_StartTrigger_GetValue_Event_In_EVENT){ClearEvent(RTE_Trigger_StartTrigger_GetValue_Event_In_EVENT);*transmit_pack_ptr = null;transmit_pack_ptr++;strcpy(BT_transmit_package, COMSERVICE_transmit_package[null]);SetEvent(BT_IMPLIZIT_SLAVE,BT_SEND_MY_MESSAGE);}

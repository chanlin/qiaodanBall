//package com.qiaodan.smartball.pullUtils;
//
//public class Gatt {
//
//	public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
//        String  intentAction;
//        if(status == BluetoothGatt.GATT_SUCCESS) {
//            if(newState == BluetoothProfile.STATE_CONNECTED) {
//                intentAction = BluetoothConstants.ACTION_GATT_CONNECTED;
//                mBLEConnectionState = BluetoothConstants.BLE_STATE_CONNECTED;
//                broadcastUpdate(intentAction);
//                Log.i(TAG,"Connected to GATT server.");
//                Log.i(TAG,"Attempting to start service discovery:" + mBluetoothGatt.discoverServices());
//            }else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
//                intentAction = BluetoothConstants.ACTION_GATT_DISCONNECTED;
//                mBLEConnectionState = BluetoothConstants.BLE_STATE_DISCONNECTED;
//                close();// 防止出现status 133
//                Log.i(TAG,"Disconnected from GATT server.");
//                broadcastUpdate(intentAction);
//            }
//        }else{
//            Log.d(TAG,"onConnectionStateChange received: " + status);
//            intentAction = BluetoothConstants.GATT_STATUS_133;
//            mBLEConnectionState = BluetoothConstants.BLE_STATE_DISCONNECTED;
//            close();// 防止出现status 133
//            broadcastUpdate(intentAction);
//            connect(reConnectAddress);
//        }
//    }
//	
//	public	void	close() {
//	    if	(mBluetoothGatt == null)	 {
//	        return;
//	    }
//	    Log.w(TAG,	"mBluetoothGatt	 closed");
//	    mBluetoothDeviceAddress	 = null;
//	    disconnect();
//	    mBluetoothGatt.close();
//	    mBluetoothGatt	 = null;
//	}
//
//}

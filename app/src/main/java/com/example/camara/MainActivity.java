package com.example.camara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ContentFrameLayout;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //private Switch btn_encender;
    private Boolean encendida = false;
    private CameraManager camara;
    private String idCamara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camara = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            idCamara = camara.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void encender(View v){
        if(!encendida){
            encendida = true;
        }
        else if(encendida) {
            encendida = false;
        }
        try {
            camara.setTorchMode(idCamara, encendida);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}

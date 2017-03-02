package com.haozi.anfixtester;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTestClick(View view){
        Toast.makeText(this,"hello!!!",Toast.LENGTH_LONG).show();
    }

    public void onUpdateClick(View view){
        String updatePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Tinker/update.path";
        File updateFile = new File(updatePath);
        if(updateFile == null || !updateFile.exists()){
            boolean mkOk = updateFile.getParentFile().mkdirs();
            if(!mkOk){
                Log.i("onUpdateClick", "XXX-->> LOG_PATH_MEMORY_DIR File dir created failed ："+updatePath);
            }else{
                Log.i("onUpdateClick", "YYY-->> LOG_PATH_MEMORY_DIR File dir created："+updatePath);
            }
            Toast.makeText(this,"path file is empty!!!",Toast.LENGTH_LONG).show();
            return;
        }
        TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), updatePath);
    }
}

package com.example.lx1;

        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.DialogInterface;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button) this.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个对话框").setTitle("对话框");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(MainActivity.this, "用户按下确认", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(MainActivity.this, "用户按下取消", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(MainActivity.this, "用户按下忽略", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });
        Button but1=(Button) this.findViewById(R.id.button1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog
                        .Builder(MainActivity.this);
                LayoutInflater factor = LayoutInflater.from(MainActivity.this);
                final View v1 = factor.inflate(R.layout.login_dialog,null);
                builder.setView(v1)
                        .setTitle("Login")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int id) {
                                EditText edit_id = v1.findViewById(R.id.User);
                                EditText edit_pa = v1.findViewById(R.id.Password);

                                String userid = edit_id.getText().toString();
                                String password = edit_pa.getText().toString();
                                if (userid.equals("abc") && password.equals("123")) {
                                    Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_LONG).show();
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int id) {
                                //cancel
                            }
                        });
                builder.show();
            }
        });
    }
}
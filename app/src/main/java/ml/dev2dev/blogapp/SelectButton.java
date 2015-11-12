package ml.dev2dev.blogapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectButton extends AppCompatActivity {
Button cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_button);
        cont = (Button) findViewById(R.id.cont);
              cont.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent = new Intent(SelectButton.this, Content.class);
                      startActivity(intent);
                      finish();
                  }
              });
    }
}

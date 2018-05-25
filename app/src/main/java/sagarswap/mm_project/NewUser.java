package sagarswap.mm_project;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class NewUser extends AppCompatActivity {
    EditText owner, vehicle, no;
    Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        owner=findViewById(R.id.OwnerName);
        vehicle=findViewById(R.id.VehicleName);
        no=findViewById(R.id.VehicleNumber);
        Save=findViewById(R.id.SaveButton);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO save to database
                AppDatabase db= Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production").allowMainThreadQueries().fallbackToDestructiveMigration().build();
                //DO NOT DO THE ABOVE STATEMENT IN THE FINAL VERSION, use background thread to accomplish this task using async operations

                User user=new User(owner.getText().toString(), vehicle.getText().toString(), no.getText().toString());
                db.userDAO().insertAll(user);
                startActivity(new Intent(NewUser.this, Main_Page.class));
                finish();
            }
        });
    }
}

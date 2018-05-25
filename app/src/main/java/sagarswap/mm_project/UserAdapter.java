package sagarswap.mm_project;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> users;

    public UserAdapter(List<User> users)
    {
        this.users=users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position)
    {
        holder.ownerName.setText(users.get(position).getOwnerName());
        holder.vehicleName.setText(users.get(position).getVehicleName());
        holder.vehicleNumber.setText(users.get(position).getVehicleNumber());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ownerName, vehicleName, vehicleNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            ownerName=itemView.findViewById(R.id.owner_name);
            vehicleName=itemView.findViewById(R.id.vehicle_name);
            vehicleNumber=itemView.findViewById(R.id.vehicle_number);
        }
    }
}

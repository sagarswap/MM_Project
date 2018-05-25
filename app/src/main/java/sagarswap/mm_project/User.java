package sagarswap.mm_project;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity //This causes the data to be stored in a database
public class User
{
    public User(String ownerName, String vehicleName, String vehicleNumber)
    {
        this.ownerName=ownerName;
        this.vehicleName=vehicleName;
        this.vehicleNumber=vehicleNumber;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "owner_name")
    private String ownerName;

    @ColumnInfo(name = "vehicle_name")
    private String vehicleName;

    @ColumnInfo(name = "vehicle_number")
    private String vehicleNumber;

    public void setId(long id)
    {
        this.id=id;
    }
    public long getId()
    {
        return id;
    }

    public String getOwnerName()
    {
        return ownerName;
    }
    public void setOwnerName(String ownerName)
    {
        this.ownerName=ownerName;
    }

    public String getVehicleName()
    {
        return vehicleName;
    }
    public void setVehicleName(String vehicleName)
    {
        this.vehicleName=vehicleName;
    }

    public String getVehicleNumber()
    {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber)
    {
        this.vehicleNumber=vehicleNumber;
    }
}

package database;

import commands.AirplaneRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DBAdmin {
    private String database;

    private void printRecords(ArrayList<AirplaneRecord> records, int offset, int limit) {
        int end = limit;
        if (end > records.size()) {
            end = records.size();
        }
        for (int i = offset; i < end; i++) {
            System.out.println(records.get(i));
        }
    }

    public DBAdmin(String database) {
        this.database = database;
    }

    private boolean isExistingDatabase() {
        try {
            FileInputStream fileStream = new FileInputStream(this.database);
        } catch(Exception ex) {
            return false;
        }
        return true;
    }

    // Serialization:
    public void saveNewRecord(AirplaneRecord record) {
        if(isExistingDatabase()) {
            try {
                FileInputStream fileStream = new FileInputStream(this.database);
                ObjectInputStream is = new ObjectInputStream(fileStream);
                Object obj = is.readObject();
                ArrayList<AirplaneRecord> records = (ArrayList<AirplaneRecord>) obj;
                try {
                    FileOutputStream fs = new FileOutputStream(this.database);
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    records.add(record);
                    Collections.sort(records);
                    os.writeObject(records);
                    os.close();
                    System.out.println("Airplane saved successfully.");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                is.close();
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
        }
        else {
            try {
                FileOutputStream fs = new FileOutputStream(this.database);
                ObjectOutputStream os = new ObjectOutputStream(fs);
                ArrayList<AirplaneRecord> records = new ArrayList<AirplaneRecord>();
                records.add(record);
                os.writeObject(records);
                os.close();
                System.out.println("Airplane saved successfully.");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    // Deserialization:
    public void showRecords(int offset, int limit) {
        try {
            FileInputStream fileStream = new FileInputStream(this.database);
            ObjectInputStream os = new ObjectInputStream(fileStream);
            Object obj = os.readObject();
            ArrayList<AirplaneRecord> records = (ArrayList<AirplaneRecord>) obj;
            printRecords(records, offset, limit);
            os.close();
        } catch (Exception ioException) {
            ioException.printStackTrace();
        }
    }
}

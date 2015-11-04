/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1java;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class TableModel extends AbstractTableModel{
    
    
    public TableModel() {
        super();
        
    }
    
    @Override
    public int getRowCount() {
        FileOutput file = new FileOutput();        
        ArrayList<String[]> users = new ArrayList();
        users = file.getCSV();
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FileOutput file = new FileOutput();        
        ArrayList<String[]> users = new ArrayList();
        users = file.getCSV();
        switch(columnIndex) {
            case 0:
                return (String)users.get(rowIndex)[0];
            case 1:
                return (String)users.get(rowIndex)[1];
            case 2:
                String blocked = (String)users.get(rowIndex)[2];
                if(blocked.equals("-"))
                    return false;
                else if(blocked.equals("+"))
                    return true;                
            case 3:
                String restricted = (String)users.get(rowIndex)[3];
                if(restricted.equals("-"))
                    return false;
                else if(restricted.equals("+"))
                    return true; 
            default:
                return "";
        }
    }
    
    @Override
    public void setValueAt(Object value, int r, int c) {
        FileOutput file = new FileOutput();        
        ArrayList<String[]> users = new ArrayList();
        users = file.getCSV();
        System.out.println(value);
        switch(c) {
            case 0:
                break;
            case 1:
                break;
            case 2:                
                if((Boolean)value == true)
                    users.get(r)[c] = "+";
                else if((Boolean)value == false)
                    users.get(r)[c] = "-";
                break;
            case 3:
                if((Boolean)value == true)
                    users.get(r)[c] = "+";
                else if((Boolean)value == false)
                    users.get(r)[c] = "-";
                break;
        }        
        fireTableCellUpdated(r, c);
        file.writeCSV(users);
    }
    
    @Override
    public boolean isCellEditable(int r, int c) {
        boolean[] canEdit = new boolean [] {false, false, true, true};
        return canEdit[c];
    }
    
    @Override
    public Class getColumnClass(int columnIndex) {
        Class[] types = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class};
        return types [columnIndex];
    }
    
    @Override
    public String getColumnName(int c) {
        String[] columnNames = {"name", "password", "blocked", "restricted"};
        return columnNames[c];
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelos;

import javax.swing.JTable;
import javax.swing.event.*;


    class MiTablaModelListener implements TableModelListener {

        JTable table;

        // It is necessary to keep the table since it is not possible
        // to determine the table from the event's source
        MiTablaModelListener(JTable table) {
            this.table = table;
        }

        @Override
        public void tableChanged(TableModelEvent e) {
            System.out.println("tableChanged:" + e);
            int firstRow = e.getFirstRow();
            int lastRow = e.getLastRow();
            int mColIndex = e.getColumn();

            switch (e.getType()) {
                case TableModelEvent.INSERT:
                    // The inserted rows are in the range [firstRow, lastRow]
                    for (int r = firstRow; r <= lastRow; r++) {
                        // Row r was inserted
                    }
                    break;
                case TableModelEvent.UPDATE:
                    System.out.println("tableChanged-> UPDATE");
                    //table.firefireTableChanged(e);
                    if (firstRow == TableModelEvent.HEADER_ROW) {
                        if (mColIndex == TableModelEvent.ALL_COLUMNS) {
                            // A column was added
                        } else {
                            // Column mColIndex in header changed
                        }
                    } else {
                        // The rows in the range [firstRow, lastRow] changed
                        for (int r = firstRow; r <= lastRow; r++) {
                            // Row r was changed

                            if (mColIndex == TableModelEvent.ALL_COLUMNS) {
                                // All columns in the range of rows have changed
                            } else {
                                // Column mColIndex changed
                            }
                        }
                    }
                    break;
                case TableModelEvent.DELETE:
                    // The rows in the range [firstRow, lastRow] changed
                    for (int r = firstRow; r <= lastRow; r++) {
                        // Row r was deleted
                    }
                    break;
            }
        }
    }

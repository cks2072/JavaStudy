package chap19.common;

import javax.swing.table.AbstractTableModel;

public class RentTableModel extends AbstractTableModel {
	
	Object[][] data;
	String[] columnNames;
	boolean[] columnEditables = new boolean[] { false, true, true, true, true, true };
	
	// 생성자
	public RentTableModel(Object[][] data, String[] columnNames) {
		this.data = data;
		this.columnNames = columnNames;
	}


	@Override
	public int getRowCount() {
		// 테이블 행의 수를 지정
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// 테이블의 컬럼 수
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// 각 셀의 값
		return data[rowIndex][columnIndex];
	}
	
	// 테이블 컬럼 이름
	public String getColumnName(int column) {
		return columnNames[column];	
	}
	
	// 테이블에 있는 특정 위치에 있는 행을 편집 여부 설정
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	// 테이블의 특정 위치에 있는 값 수정
	public void setValueAt(Object value, int row, int column) {
		data[row][column] = value;
		fireTableCellUpdated(row, column);
	}
	
}

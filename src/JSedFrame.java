import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class JSedFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JSplitPane jSplitPane = null;

	private JSplitPane jSplitPane1 = null;

	private JScrollPane jScrollPane = null;

	private JTextArea taInput = null;

	private JScrollPane jScrollPane1 = null;

	private JTextArea taResult = null;

	private final DefaultTableModel expressionTableModel = new DefaultTableModel(new String[]{"Search","Replace"}, 0);

	private JButton jButton = null;

	private JPanel jPanel1 = null;

	private JScrollPane jScrollPane2 = null;

	private JTable jTable = null;

	private JPanel jPanel2 = null;

	private JButton btnAddRow = null;

	private JButton btnLoad = null;

	private JButton jButton1 = null;

	/**
	 * This is the default constructor
	 */
	public JSedFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(600, 400);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		
		// synchronise the scrolling of the two text areas
		jScrollPane.getVerticalScrollBar().setModel(jScrollPane1.getVerticalScrollBar().getModel());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJSplitPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jSplitPane	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setResizeWeight(0.75D);
			jSplitPane.setRightComponent(getJPanel1());
			jSplitPane.setLeftComponent(getJSplitPane1());
		}
		return jSplitPane;
	}

	/**
	 * This method initializes jSplitPane1	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPane1() {
		if (jSplitPane1 == null) {
			jSplitPane1 = new JSplitPane();
			jSplitPane1.setPreferredSize(new Dimension(400, 0));
			jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			jSplitPane1.setResizeWeight(0.5D);
			jSplitPane1.setBottomComponent(getJScrollPane1());
			jSplitPane1.setTopComponent(getJScrollPane());
		}
		return jSplitPane1;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTaInput());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes taInput	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextArea getTaInput() {
		if (taInput == null) {
			taInput = new JTextArea();
		}
		return taInput;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getTaResult());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes taResult	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextArea getTaResult() {
		if (taResult == null) {
			taResult = new JTextArea();
		}
		return taResult;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Process");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					process();
				}
			});
		}
		return jButton;
	}

	@SuppressWarnings("unchecked")
	protected void process() {
		String data = taInput.getText();
		
		Vector<Vector<String>> v = expressionTableModel.getDataVector();
		for (Vector<String> row : v) {
			if(!row.elementAt(0).equals("")) {
				String search = row.elementAt(0);
				String replace = row.elementAt(1);
				data = JSedUtils.performReplace(data, search, replace);
			}
		}
		taResult.setText(data);
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.ipadx = 79;
			gridBagConstraints3.gridy = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.ipadx = -138;
			gridBagConstraints2.ipady = -113;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.gridx = 0;
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BorderLayout());
			jPanel1.add(getJScrollPane2(), BorderLayout.CENTER);
			jPanel1.add(getJPanel2(), BorderLayout.SOUTH);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getJTable());
		}
		return jScrollPane2;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			jTable.setModel(expressionTableModel);
			expressionTableModel.setColumnCount(2);
			expressionTableModel.setColumnIdentifiers(new String[]{"Search", "Replace"});
		}
		return jTable;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridwidth = 2;
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.gridy = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.gridx = 1;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridy = 1;
			gridBagConstraints31.weightx = 1.0;
			gridBagConstraints31.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints31.gridx = 0;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridy = 0;
			gridBagConstraints21.gridwidth = 2;
			gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 2;
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 0;
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.add(getBtnAddRow(), gridBagConstraints21);
			jPanel2.add(getBtnLoad(), gridBagConstraints31);
			jPanel2.add(getJButton1(), gridBagConstraints4);
			jPanel2.add(getJButton(), gridBagConstraints5);
		}
		return jPanel2;
	}

	/**
	 * This method initializes btnAddRow	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAddRow() {
		if (btnAddRow == null) {
			btnAddRow = new JButton();
			btnAddRow.setText("Add Row");
			btnAddRow.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					addNewExpression();
				}
			});
		}
		return btnAddRow;
	}

	protected void addNewExpression() {
		expressionTableModel.addRow(new String[]{"",""});
	}

	/**
	 * This method initializes btnLoad	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnLoad() {
		if (btnLoad == null) {
			btnLoad = new JButton();
			btnLoad.setText("Load");
			btnLoad.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					load();
				}
			});
		}
		return btnLoad;
	}

	protected void load() {
		JFileChooser jfc = new JFileChooser();
		if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {	
			try {
				String data = JSedUtils.readFile(jfc.getSelectedFile());
				
				String[] rows = data.split("\n");
				for (int i = 0; i < rows.length; i++) {
					String csvRow = rows[i];
					expressionTableModel.addRow(JSedUtils.parseCSV(csvRow));
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error", e.getMessage(), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Save");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					save();
				}
			});
		}
		return jButton1;
	}

	@SuppressWarnings("unchecked")
	protected void save() {
		StringBuffer data = new StringBuffer();
		Vector<Vector<String>> v = expressionTableModel.getDataVector();
		for (Vector<String> row : v) {
			data.append("\"");
			data.append(row.elementAt(0));
			data.append("\",\"");
			data.append(row.elementAt(1));
			data.append("\"");
			data.append("\n");
		}
		
		JFileChooser jfc = new JFileChooser();
		int result = jfc.showSaveDialog(this);
		if(result==jfc.APPROVE_OPTION) {
			File f = jfc.getSelectedFile();
			if(f.exists()) {
				int confirm = JOptionPane.showConfirmDialog(this, "Overwrite existing file?");
				if(confirm==JOptionPane.YES_OPTION) {
					try {
						JSedUtils.writeFile(f, data.toString());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(this, "Error", e.getMessage(), JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final JSedFrame sedFrame = new JSedFrame();
				sedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				sedFrame.setVisible(true);
			}
		});
	}
	
}

package Sport;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Interface {
	private JComboBox<String> comboBoxPlayers;
	private JButton btnEditStats;
	private JButton btnEditPlayer;
    private JButton btnEdit;
    private JButton btnAddStats;
    private JButton btnAddPlayer;
    private JButton btnAdd;
    private boolean isEditMode = false;
    private boolean isPlayerEditMode = false;
    private boolean isStatsEditMode = false;
    Connection conn = null;
    PreparedStatement state = null;
    ResultSet result;
    
    private JFrame frmSport;
    private JTextField textName;
    private JTable tableTeams;
    private JTextField textYear;
    private JTextField textPlayerName;
    private JTextField textDateOfBirth;
    private JTable tablePlayers;
    private JComboBox<String> comboBoxTeams;
    private JTextField textDate;
    private JTextField textPoints;
    private JTextField textAssists;
    private JTable tableStats;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interface window = new Interface();
                    window.frmSport.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Interface() {
        initialize();
    }

    private void initialize() {
        frmSport = new JFrame();
        frmSport.setResizable(false);
        frmSport.setTitle("Sport");
        frmSport.setBounds(100, 100, 739, 571);
        frmSport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frmSport.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 707, 538);
        panel.add(tabbedPane);
        
        JPanel panel_Teams = new JPanel();
        tabbedPane.addTab("Teams", null, panel_Teams, null);
        panel_Teams.setLayout(null);
        
        JLabel lblName = new JLabel("Team Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblName.setBounds(38, 20, 114, 23);
        panel_Teams.add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textName.setBounds(38, 53, 141, 30);
        panel_Teams.add(textName);
        textName.setColumns(10);
        
        JLabel lblYear = new JLabel("Establishment Year");
        lblYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblYear.setBounds(38, 120, 145, 14);
        panel_Teams.add(lblYear);
        
        textYear = new JTextField();
        textYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textYear.setBounds(39, 144, 141, 30);
        panel_Teams.add(textYear);
        textYear.setColumns(10);
        
        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAdd.setBounds(269, 45, 114, 45);
        panel_Teams.add(btnAdd);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDelete.setBounds(269, 139, 114, 45);
        panel_Teams.add(btnDelete);
        
        btnEdit = new JButton("Edit");
        btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEdit.setBounds(413, 139, 114, 45);
        panel_Teams.add(btnEdit);
        
        JButton btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		searchTeams();
        	}
        });
        btnSearch.setBounds(413, 45, 114, 45);
        panel_Teams.add(btnSearch);
        
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnRefresh.setBounds(555, 91, 114, 45);
        panel_Teams.add(btnRefresh);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 226, 685, 275);
        panel_Teams.add(scrollPane);
        
        tableTeams = new JTable();
        scrollPane.setViewportView(tableTeams);
        
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTableTeams();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isEditMode) {
                    tableTeams.setEnabled(true);
                    btnAdd.setText("Add");
                    isEditMode = false;
                    btnEdit.setText("Edit");
                } else {
                    editTeam();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTeam();
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                if (isEditMode) {
                    saveChangesTeam();
                } else {
                    addTeams();
                }
            }
        });
        
        JPanel panel_Players = new JPanel();
        tabbedPane.addTab("Players", null, panel_Players, null);
        panel_Players.setLayout(null);
        
        JLabel lblPlayerName = new JLabel("Player Name");
        lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPlayerName.setBounds(20, 81, 114, 45);
        panel_Players.add(lblPlayerName);
        
        JLabel lblDateOfBirth = new JLabel("Date of birth");
        lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDateOfBirth.setBounds(20, 155, 114, 45);
        panel_Players.add(lblDateOfBirth);
        
        textPlayerName = new JTextField();
        textPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textPlayerName.setBounds(20, 123, 114, 30);
        panel_Players.add(textPlayerName);
        textPlayerName.setColumns(10);
        
        textDateOfBirth = new JTextField();
        textDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textDateOfBirth.setColumns(10);
        textDateOfBirth.setBounds(20, 197, 114, 30);
        panel_Players.add(textDateOfBirth);
        
        btnAddPlayer = new JButton("Add");
        btnAddPlayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAddPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (isPlayerEditMode) {
                    saveChangesPlayer();
                } else {
                    addPlayer();
                }
            }
        });
        btnAddPlayer.setBounds(233, 59, 114, 45);
        panel_Players.add(btnAddPlayer);
        
        JButton btnDeletePlayer = new JButton("Delete");
        btnDeletePlayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDeletePlayer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deletePlayer();
        	}
        });
        btnDeletePlayer.setBounds(233, 155, 114, 45);
        panel_Players.add(btnDeletePlayer);
        
        btnEditPlayer = new JButton("Edit");
        btnEditPlayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEditPlayer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (isPlayerEditMode) {
                    tablePlayers.setEnabled(true);
                    btnAddPlayer.setText("Add");
                    isPlayerEditMode = false;
                    btnEditPlayer.setText("Edit");
                } else {
                    editPlayer();
                }
        	}
        });
        btnEditPlayer.setBounds(393, 155, 114, 45);
        panel_Players.add(btnEditPlayer);
        
        JButton btnSearchPlayer = new JButton("Search");
        btnSearchPlayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearchPlayer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		searchPlayers();
        	}
        });
        btnSearchPlayer.setBounds(393, 59, 114, 45);
        panel_Players.add(btnSearchPlayer);
        
        JButton btnRefreshPlayer = new JButton("Refresh");
        btnRefreshPlayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnRefreshPlayer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		refreshTablePlayers();
        	}
        });
        btnRefreshPlayer.setBounds(550, 108, 114, 45);
        panel_Players.add(btnRefreshPlayer);
        
        JScrollPane scrollPanePlayer = new JScrollPane();
        scrollPanePlayer.setBounds(10, 250, 682, 249);
        panel_Players.add(scrollPanePlayer);
        
        tablePlayers = new JTable();
        scrollPanePlayer.setViewportView(tablePlayers);
        
        comboBoxTeams = new JComboBox<>();
        comboBoxTeams.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBoxTeams.setBounds(20, 53, 114, 30);
        panel_Players.add(comboBoxTeams);
        
        JLabel lblNewLabel = new JLabel("Team");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(20, 10, 114, 45);
        panel_Players.add(lblNewLabel);
        
        JPanel panel_PlayerStatistics = new JPanel();
        tabbedPane.addTab("Stats", null, panel_PlayerStatistics, null);
        panel_PlayerStatistics.setLayout(null);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 248, 682, 251);
        panel_PlayerStatistics.add(scrollPane_1);
        
        tableStats = new JTable();
        scrollPane_1.setViewportView(tableStats);
        
        btnAddStats = new JButton("Add");
        btnAddStats.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAddStats.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (isStatsEditMode) {
                    saveChangesStats();
                } else {
                    addStats();
                }
        	}
        });
        btnAddStats.setBounds(402, 33, 114, 45);
        panel_PlayerStatistics.add(btnAddStats);
        
        JButton btnDeleteStats = new JButton("Delete");
        btnDeleteStats.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDeleteStats.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		deletePlayerStatistic();
        	}
        });
        btnDeleteStats.setBounds(402, 108, 114, 45);
        panel_PlayerStatistics.add(btnDeleteStats);
        
        btnEditStats = new JButton("Edit");
        btnEditStats.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEditStats.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (isStatsEditMode) {
                    tableStats.setEnabled(true);
                    btnAddStats.setText("Add");
                    isStatsEditMode = false;
                    btnEditStats.setText("Edit");
                    comboBoxPlayers.setEnabled(true);
                } else {
                    editStats();
                }
        	}
        });
        btnEditStats.setBounds(563, 33, 114, 45);
        panel_PlayerStatistics.add(btnEditStats);
        
        JButton btnSearchStats = new JButton("Search");
        btnSearchStats.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearchStats.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		searchStats();
        	}
        });
        btnSearchStats.setBounds(563, 108, 114, 45);
        panel_PlayerStatistics.add(btnSearchStats);
        
        JButton btnRefreshStats = new JButton("Refresh");
        btnRefreshStats.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        btnRefreshStats.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		refreshTableStats();
        	}
        });
        btnRefreshStats.setBounds(480, 179, 114, 45);
        panel_PlayerStatistics.add(btnRefreshStats);
        
        comboBoxPlayers = new JComboBox<String>();
        comboBoxPlayers.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBoxPlayers.setBounds(21, 40, 114, 30);
        panel_PlayerStatistics.add(comboBoxPlayers);
        
        JLabel lblNewLabel_1 = new JLabel("Player");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(21, 0, 114, 45);
        panel_PlayerStatistics.add(lblNewLabel_1);
        
        textDate = new JTextField();
        textDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textDate.setColumns(10);
        textDate.setBounds(21, 136, 114, 30);
        panel_PlayerStatistics.add(textDate);
        
        JLabel lblNewLabel_2 = new JLabel("Date");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(21, 88, 114, 45);
        panel_PlayerStatistics.add(lblNewLabel_2);
        
        textPoints = new JTextField();
        textPoints.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textPoints.setColumns(10);
        textPoints.setBounds(242, 41, 114, 30);
        panel_PlayerStatistics.add(textPoints);
        
        textAssists = new JTextField();
        textAssists.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textAssists.setColumns(10);
        textAssists.setBounds(242, 138, 114, 30);
        panel_PlayerStatistics.add(textAssists);
        
        JLabel lblNewLabel_3 = new JLabel("Points");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(242, 0, 114, 45);
        panel_PlayerStatistics.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Assists");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(242, 88, 114, 45);
        panel_PlayerStatistics.add(lblNewLabel_4);
        refreshTableTeams();
        refreshTablePlayers();
        refreshTableStats();
        refreshComboBoxTeams();
        refreshComboBoxPlayersStats();
    }
    
    public void refreshComboBoxTeams() {
        Connection conn = DBConnection.getConnection();
        comboBoxTeams.removeAllItems();
        comboBoxTeams.addItem("");
        try {
            PreparedStatement state = conn.prepareStatement("SELECT TEAM_NAME FROM Teams");
            result = state.executeQuery();
            while (result.next()) {
                comboBoxTeams.addItem(result.getString("TEAM_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTeams() {
        String name = textName.getText();
        int age = Integer.parseInt(textYear.getText());
        
        if (isDuplicateTeam(name, age)) {
            JOptionPane.showMessageDialog(null, "Team already exists.");
            return;
        }

        Connection conn = DBConnection.getConnection();

        try {
            String sql = "INSERT INTO TEAMS (TEAM_NAME , ESTABLISHMENT_YEAR ) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, age);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                // JOptionPane.showMessageDialog(null, "Data added successfully!");
            } else {
                // JOptionPane.showMessageDialog(null, "Failed to add data to the database!");
            }

            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        refreshTableTeams();
        refreshComboBoxTeams();
    }

    public void refreshTableTeams(){
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement state = conn.prepareStatement("SELECT * FROM Teams");
            result = state.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tableTeams.setModel(model);
            model.addColumn("Team Name");
            model.addColumn("Establishment Year");
            while (result.next()) {
                String teamName = result.getString("TEAM_NAME");
                int establishmentYear = result.getInt("ESTABLISHMENT_YEAR");
                model.addRow(new Object[]{teamName, establishmentYear});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeam() {
        int selectedRow = tableTeams.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            return;
        }

        String teamName = (String) tableTeams.getValueAt(selectedRow, 0);
        int establishmentYear = (int) tableTeams.getValueAt(selectedRow, 1);

        Connection conn = DBConnection.getConnection();

        try {
        	String sqlCheckPlayers = "SELECT COUNT(*) AS playerCount FROM PLAYERS WHERE TEAM_ID = (SELECT TEAM_ID FROM TEAMS WHERE TEAM_NAME = ? AND ESTABLISHMENT_YEAR = ?)";
            PreparedStatement checkPlayersStatement = conn.prepareStatement(sqlCheckPlayers);
            checkPlayersStatement.setString(1, teamName);
            checkPlayersStatement.setInt(2, establishmentYear);
            ResultSet playerCountResult = checkPlayersStatement.executeQuery();
            if (playerCountResult.next()) {
                int playerCount = playerCountResult.getInt("playerCount");
                if (playerCount > 0) {
                    JOptionPane.showMessageDialog(null, "Cannot delete team with players.");
                    return;
                }
            }
            String sql = "DELETE FROM TEAMS WHERE TEAM_NAME=? AND ESTABLISHMENT_YEAR=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, teamName);
            statement.setInt(2, establishmentYear);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                // JOptionPane.showMessageDialog(null, "Team deleted successfully.");
            } else {
                // JOptionPane.showMessageDialog(null, "Failed to delete team.");
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        refreshTableTeams();
        refreshComboBoxTeams();
    }

    public void editTeam() {
        int selectedRow = tableTeams.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to edit.");
            return;
        }

        String teamName = (String) tableTeams.getValueAt(selectedRow, 0);
        int establishmentYear = (int) tableTeams.getValueAt(selectedRow, 1);
        textName.setText(teamName);
        textYear.setText(String.valueOf(establishmentYear));
        isEditMode = true;
        tableTeams.setEnabled(false);
        btnAdd.setText("Save");
        btnEdit.setText("Cancel");
    }

    public void saveChangesTeam() {
        int selectedRow = tableTeams.getSelectedRow();
        String name = textName.getText();
        int age = Integer.parseInt(textYear.getText());
        String originalTeamName = (String) tableTeams.getValueAt(selectedRow, 0);
        int originalEstablishmentYear = (int) tableTeams.getValueAt(selectedRow, 1);
        if (isDuplicateTeam(name, age)) {
            JOptionPane.showMessageDialog(null, "Team already exists.");
            return;
        }
        
        Connection conn = DBConnection.getConnection();

        try {
            String sql = "UPDATE TEAMS SET TEAM_NAME=?, ESTABLISHMENT_YEAR=? WHERE TEAM_NAME=? AND ESTABLISHMENT_YEAR=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, originalTeamName);
            statement.setInt(4, originalEstablishmentYear);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                // JOptionPane.showMessageDialog(null, "Changes saved successfully!");
            } else {
                // JOptionPane.showMessageDialog(null, "Failed to save changes to the team!");
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        isEditMode = false;
        tableTeams.setEnabled(true);
        btnAdd.setText("Add");
        btnEdit.setText("Cancel");
        refreshTableTeams();
        refreshTablePlayers();
        refreshComboBoxTeams();
    }

    public void addPlayer() {
        String playerName = textPlayerName.getText();
        String dateOfBirth = textDateOfBirth.getText();
        String teamName = (String) comboBoxTeams.getSelectedItem();

        Connection conn = DBConnection.getConnection();

        try {
            String sqlGetTeamID = "SELECT TEAM_ID FROM TEAMS WHERE TEAM_NAME=?";
            PreparedStatement statement = conn.prepareStatement(sqlGetTeamID);
            statement.setString(1, teamName);
            ResultSet rs = statement.executeQuery();
            int teamID = 0;
            if (rs.next()) {
                teamID = rs.getInt("TEAM_ID");
            }
            if (isDuplicatePlayer(playerName, teamID, dateOfBirth)) {
                JOptionPane.showMessageDialog(null, "Player already exists.");
                return;
            }
            String sqlInsertPlayer = "INSERT INTO PLAYERS (TEAM_ID, PLAYER_NAME, DATE_OF_BIRTH) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(sqlInsertPlayer);
            insertStatement.setInt(1, teamID);
            insertStatement.setString(2, playerName);
            insertStatement.setString(3, dateOfBirth);

            int rowsInserted = insertStatement.executeUpdate();
            if (rowsInserted > 0) {
            //    JOptionPane.showMessageDialog(null, "Player added successfully!");
            } else {
            //    JOptionPane.showMessageDialog(null, "Failed to add player!");
            }

            rs.close();
            statement.close();
            insertStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        refreshTablePlayers();
        refreshComboBoxPlayersStats();
    }
    public void refreshTablePlayers() {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement state = conn.prepareStatement("SELECT TEAMS.TEAM_NAME, PLAYERS.PLAYER_NAME, PLAYERS.DATE_OF_BIRTH " +
                                                            "FROM TEAMS INNER JOIN PLAYERS " +
                                                            "ON TEAMS.TEAM_ID = PLAYERS.TEAM_ID");
            result = state.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tablePlayers.setModel(model);
            
            model.addColumn("Team");
            model.addColumn("Player Name");
            model.addColumn("Date Of Birth");

            int columnWidth = 680 / 3;
            tablePlayers.getColumnModel().getColumn(0).setPreferredWidth(columnWidth);
            tablePlayers.getColumnModel().getColumn(1).setPreferredWidth(columnWidth);
            tablePlayers.getColumnModel().getColumn(2).setPreferredWidth(columnWidth);

            tablePlayers.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            while (result.next()) {
                String teamName = result.getString("TEAM_NAME");
                String playerName = result.getString("PLAYER_NAME");
                String dateOfBirth = result.getString("DATE_OF_BIRTH");
                model.addRow(new Object[]{teamName, playerName, dateOfBirth});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletePlayer() {
        int selectedRow = tablePlayers.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            return;
        }

        String playerName = (String) tablePlayers.getValueAt(selectedRow, 1);
        String teamName = (String) tablePlayers.getValueAt(selectedRow, 0);
        String dateOfBirth = (String) tablePlayers.getValueAt(selectedRow, 2);

        Connection conn = DBConnection.getConnection();

        try {
            String sqlGetTeamID = "SELECT TEAM_ID FROM TEAMS WHERE TEAM_NAME=?";
            PreparedStatement statement = conn.prepareStatement(sqlGetTeamID);
            statement.setString(1, teamName);
            ResultSet rs = statement.executeQuery();
            int teamID = 0;
            if (rs.next()) {
                teamID = rs.getInt("TEAM_ID");
            }

            String sqlDeletePlayer = "DELETE FROM PLAYERS WHERE TEAM_ID=? AND PLAYER_NAME=? AND DATE_OF_BIRTH=?";
            PreparedStatement deleteStatement = conn.prepareStatement(sqlDeletePlayer);
            deleteStatement.setInt(1, teamID);
            deleteStatement.setString(2, playerName);
            deleteStatement.setString(3, dateOfBirth);

            int rowsDeleted = deleteStatement.executeUpdate();
            if (rowsDeleted > 0) {
                // JOptionPane.showMessageDialog(null, "Player deleted successfully.");
            } else {
                // JOptionPane.showMessageDialog(null, "Failed to delete player.");
            }

            rs.close();
            statement.close();
            deleteStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        refreshTablePlayers();
        refreshTableStats();
        refreshComboBoxPlayersStats();
    }
    public void editPlayer() {
        int selectedRow = tablePlayers.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to edit.");
            return;
        }

        String teamName = (String) tablePlayers.getValueAt(selectedRow, 0);
        String playerName = (String) tablePlayers.getValueAt(selectedRow, 1);
        String dateOfBirth = (String) tablePlayers.getValueAt(selectedRow, 2);

        textPlayerName.setText(playerName);
        textDateOfBirth.setText(dateOfBirth);
        comboBoxTeams.setSelectedItem(teamName);
        comboBoxTeams.setEnabled(false);
        isPlayerEditMode = true;
        tablePlayers.setEnabled(false);
        btnAddPlayer.setText("Save");
        btnEditPlayer.setText("Cancel");
    }
    public void saveChangesPlayer() {
        int selectedRow = tablePlayers.getSelectedRow();
        String playerName = textPlayerName.getText();
        String dateOfBirth = textDateOfBirth.getText();
        String teamName = comboBoxTeams.getSelectedItem().toString();

        Connection conn = DBConnection.getConnection();

        try {
            String sqlGetTeamID = "SELECT TEAM_ID FROM TEAMS WHERE TEAM_NAME=?";
            PreparedStatement statement = conn.prepareStatement(sqlGetTeamID);
            statement.setString(1, teamName);
            ResultSet rs = statement.executeQuery();
            int teamID = 0;
            if (rs.next()) {
                teamID = rs.getInt("TEAM_ID");
            }
            if (isDuplicatePlayer(playerName, teamID, dateOfBirth)) {
                JOptionPane.showMessageDialog(null, "Player already exists.");
                return;
            }
            String sqlUpdatePlayer = "UPDATE PLAYERS SET PLAYER_NAME=?, DATE_OF_BIRTH=?, TEAM_ID=? WHERE TEAM_ID=? AND PLAYER_NAME=? AND DATE_OF_BIRTH=?";
            PreparedStatement updateStatement = conn.prepareStatement(sqlUpdatePlayer);
            updateStatement.setString(1, playerName);
            updateStatement.setString(2, dateOfBirth);
            updateStatement.setInt(3, teamID);
            updateStatement.setInt(4, teamID);
            updateStatement.setString(5, (String) tablePlayers.getValueAt(selectedRow, 1));
            updateStatement.setString(6, (String) tablePlayers.getValueAt(selectedRow, 2));

            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                // JOptionPane.showMessageDialog(null, "Changes saved successfully!");
            } else {
                // JOptionPane.showMessageDialog(null, "Failed to save.");
            }

            rs.close();
            statement.close();
            updateStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        comboBoxTeams.setEnabled(true);
        isPlayerEditMode = false;
        tablePlayers.setEnabled(true);
        btnAddPlayer.setText("Add");
        btnEditPlayer.setText("Edit");
        refreshTablePlayers();
        refreshTableStats();
        refreshComboBoxPlayersStats();
    }
    public void refreshComboBoxPlayersStats() {
        Connection conn = DBConnection.getConnection();
        comboBoxPlayers.removeAllItems();
        comboBoxPlayers.addItem("");
        try {
            PreparedStatement state = conn.prepareStatement("SELECT PLAYER_NAME FROM PLAYERS");
            ResultSet result = state.executeQuery();
            while (result.next()) {
                comboBoxPlayers.addItem(result.getString("PLAYER_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addStats() {
        String playerName = comboBoxPlayers.getSelectedItem().toString();
        String date = textDate.getText();
        int points = Integer.parseInt(textPoints.getText());
        int assists = Integer.parseInt(textAssists.getText());

        Connection conn = DBConnection.getConnection();

        try {
            String getPlayerIDQuery = "SELECT PLAYER_ID FROM PLAYERS WHERE PLAYER_NAME=?";
            PreparedStatement getPlayerIDStatement = conn.prepareStatement(getPlayerIDQuery);
            getPlayerIDStatement.setString(1, playerName);
            ResultSet playerIDResult = getPlayerIDStatement.executeQuery();
            int playerID = 0;
            if (playerIDResult.next()) {
                playerID = playerIDResult.getInt("PLAYER_ID");
            }
            if (isDuplicateStats(playerID, date, points, assists)) {
                JOptionPane.showMessageDialog(null, "Stats already exist.");
                return;
            }

            String sql = "INSERT INTO PLAYERSTATISTICS (PLAYER_ID, DATE_, POINTS, ASSISTS) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, playerID);
            statement.setString(2, date);
            statement.setInt(3, points);
            statement.setInt(4, assists);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                // JOptionPane.showMessageDialog(null, "Player stats added successfully!");
            } else {
                // JOptionPane.showMessageDialog(null, "Failed to add player stats!");
            }

            playerIDResult.close();
            getPlayerIDStatement.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        refreshTableStats();
    }
    public void refreshTableStats() {
    	Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement state = conn.prepareStatement(
                "SELECT Players.player_name, PlayerStatistics.date_, PlayerStatistics.points, PlayerStatistics.assists " +
                "FROM Players " +
                "INNER JOIN PlayerStatistics ON Players.player_id = PlayerStatistics.player_id"
            );
            ResultSet result = state.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tableStats.setModel(model);

            model.addColumn("Player Name");
            model.addColumn("Date");
            model.addColumn("Points");
            model.addColumn("Assists");

            int columnWidth = 680 / 4;
            for (int i = 0; i < 4; i++) {
                tableStats.getColumnModel().getColumn(i).setPreferredWidth(columnWidth);
            }
            tableStats.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            while (result.next()) {
                String playerName = result.getString("player_name");
                String date = result.getString("date_");
                int points = result.getInt("points");
                int assists = result.getInt("assists");
                model.addRow(new Object[]{playerName, date, points, assists});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePlayerStatistic() {
    	int selectedRow = tableStats.getSelectedRow();
    	if (selectedRow == -1) {
    	    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
    	    return;
    	}

    	String playerName = (String) tableStats.getValueAt(selectedRow, 0);
    	String date = (String) tableStats.getValueAt(selectedRow, 1);
    	int points = (int) tableStats.getValueAt(selectedRow, 2);
    	int assists = (int) tableStats.getValueAt(selectedRow, 3);

    	Connection conn = DBConnection.getConnection();

    	try {
    	    String sqlGetStatID = "SELECT stat_id FROM PlayerStatistics WHERE player_id = (SELECT player_id FROM Players WHERE player_name = ?) "
    	    		+ "AND date_ = ? AND points = ? AND assists = ?";
    	    PreparedStatement statement = conn.prepareStatement(sqlGetStatID);
    	    statement.setString(1, playerName);
    	    statement.setString(2, date);
    	    statement.setInt(3, points);
    	    statement.setInt(4, assists);
    	    ResultSet rs = statement.executeQuery();
    	    int statID = 0;
    	    if (rs.next()) {
    	        statID = rs.getInt("stat_id");
    	    }

    	    String sqlDeleteStats = "DELETE FROM PlayerStatistics WHERE stat_id = ?";
    	    PreparedStatement deleteStatement = conn.prepareStatement(sqlDeleteStats);
    	    deleteStatement.setInt(1, statID);

    	    int rowsDeleted = deleteStatement.executeUpdate();
    	    if (rowsDeleted > 0) {
    	        // JOptionPane.showMessageDialog(null, "Stats deleted successfully.");
    	    } else {
    	        // JOptionPane.showMessageDialog(null, "Failed to delete stats.");
    	    }

    	    rs.close();
    	    statement.close();
    	    deleteStatement.close();
    	} catch (SQLException ex) {
    	    ex.printStackTrace();
    	    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    	} finally {
    	    try {
    	        if (conn != null) {
    	            conn.close();
    	        }
    	    } catch (SQLException ex) {
    	        ex.printStackTrace();
    	    }
    	}
    	refreshTableStats();
    }
    public void editStats() {
        int selectedRow = tableStats.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to edit.");
            return;
        }
        String playerName = (String) tableStats.getValueAt(selectedRow, 0);
        String date = (String) tableStats.getValueAt(selectedRow, 1);
        int points = (int) tableStats.getValueAt(selectedRow, 2);
        int assists = (int) tableStats.getValueAt(selectedRow, 3);

        comboBoxPlayers.setSelectedItem(playerName);
        textDate.setText(date);
        textPoints.setText(String.valueOf(points));
        textAssists.setText(String.valueOf(assists));

        comboBoxPlayers.setEnabled(false);
        isStatsEditMode = true;
        tableStats.setEnabled(false);
        btnAddStats.setText("Save");
        btnEditStats.setText("Cancel");
    }
    public void saveChangesStats() {
    	int selectedRow = tableStats.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to save changes.");
            return;
        }
        String playerName = comboBoxPlayers.getSelectedItem().toString();
        String date = textDate.getText();
        int points = Integer.parseInt(textPoints.getText());
        int assists = Integer.parseInt(textAssists.getText());

        Connection conn = DBConnection.getConnection();
        try {
            int playerID = -1;
            String getPlayerIDQuery = "SELECT PLAYER_ID FROM PLAYERS WHERE PLAYER_NAME = ?";
            PreparedStatement getPlayerIDStatement = conn.prepareStatement(getPlayerIDQuery);
            getPlayerIDStatement.setString(1, playerName);
            ResultSet rs = getPlayerIDStatement.executeQuery();
            if (rs.next()) {
                playerID = rs.getInt("PLAYER_ID");
            }
            if (isDuplicateStats(playerID, date, points, assists)) {
                JOptionPane.showMessageDialog(null, "Stats already exist.");
                return;
            }
            rs.close();
            getPlayerIDStatement.close();
            String sqlUpdate = "UPDATE PLAYERSTATISTICS SET DATE_=?, POINTS=?, ASSISTS=? WHERE PLAYER_ID=? AND DATE_=?";
            PreparedStatement updateStatement = conn.prepareStatement(sqlUpdate);
            updateStatement.setString(1, date);
            updateStatement.setInt(2, points);
            updateStatement.setInt(3, assists);
            updateStatement.setInt(4, playerID);
            updateStatement.setString(5, (String) tableStats.getValueAt(selectedRow, 1));
            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Changes saved successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to save changes.");
            }

            updateStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        comboBoxPlayers.setEnabled(true);
        tableStats.setEnabled(true);
        btnAddStats.setText("Add");
        btnEditStats.setText("Edit");
        isStatsEditMode = false;
        refreshTableStats();
    }
    public boolean isDuplicateTeam(String name, int age) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement checkStatement = conn.prepareStatement("SELECT * FROM TEAMS WHERE TEAM_NAME=? AND ESTABLISHMENT_YEAR=?");
            checkStatement.setString(1, name);
            checkStatement.setInt(2, age);
            ResultSet resultSet = checkStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public boolean isDuplicatePlayer(String playerName, int teamID, String dateOfBirth) {
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "SELECT * FROM PLAYERS WHERE PLAYER_NAME = ? AND TEAM_ID = ? AND DATE_OF_BIRTH = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, playerName);
            statement.setInt(2, teamID);
            statement.setString(3, dateOfBirth);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public boolean isDuplicateStats(int playerId, String date, int points, int assists) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement checkStatement = conn.prepareStatement("SELECT * FROM PLAYERSTATISTICS WHERE PLAYER_ID=? AND DATE_=? AND POINTS=? AND ASSISTS=?");
            checkStatement.setInt(1, playerId);
            checkStatement.setString(2, date);
            checkStatement.setInt(3, points);
            checkStatement.setInt(4, assists);
            ResultSet resultSet = checkStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void searchTeams() {
        String teamName = textName.getText().trim();
        String year = textYear.getText().trim();

        if (teamName.isEmpty() && year.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter search criteria.");
            return;
        }

        Connection conn = DBConnection.getConnection();

        try {
            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM TEAMS WHERE 1=1");

            if (!teamName.isEmpty()) {
                sqlBuilder.append(" AND TEAM_NAME LIKE ?");
            }
            if (!year.isEmpty()) {
                sqlBuilder.append(" AND ESTABLISHMENT_YEAR = ?");
            }

            PreparedStatement statement = conn.prepareStatement(sqlBuilder.toString());

            int parameterIndex = 1;
            if (!teamName.isEmpty()) {
                statement.setString(parameterIndex++, "%" + teamName + "%");
            }
            if (!year.isEmpty()) {
                statement.setInt(parameterIndex++, Integer.parseInt(year));
            }

            ResultSet result = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            tableTeams.setModel(model);
            model.addColumn("Team Name");
            model.addColumn("Establishment Year");

            while (result.next()) {
                String foundTeamName = result.getString("TEAM_NAME");
                int establishmentYear = result.getInt("ESTABLISHMENT_YEAR");
                model.addRow(new Object[]{foundTeamName, establishmentYear});
            }

            statement.close();
        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void searchPlayers() {
        String playerName = textPlayerName.getText().trim();
        String dateOfBirth = textDateOfBirth.getText().trim();
        String teamName = comboBoxTeams.getSelectedItem().toString();

        if (playerName.isEmpty() && dateOfBirth.isEmpty() && teamName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter search criteria.");
            return;
        }

        Connection conn = DBConnection.getConnection();

        try {
            StringBuilder sqlBuilder = new StringBuilder("SELECT TEAMS.TEAM_NAME, PLAYERS.PLAYER_NAME, PLAYERS.DATE_OF_BIRTH " +
                    "FROM TEAMS INNER JOIN PLAYERS " +
                    "ON TEAMS.TEAM_ID = PLAYERS.TEAM_ID WHERE 1=1");

            if (!playerName.isEmpty()) {
                sqlBuilder.append(" AND PLAYERS.PLAYER_NAME LIKE ?");
            }
            if (!dateOfBirth.isEmpty()) {
                sqlBuilder.append(" AND PLAYERS.DATE_OF_BIRTH = ?");
            }
            if (!teamName.isEmpty()) {
                int teamID = getTeamID(teamName);
                if (teamID != -1) {
                    sqlBuilder.append(" AND PLAYERS.TEAM_ID = ?");
                } else {
                    JOptionPane.showMessageDialog(null, "Team not found.");
                    return;
                }
            }

            PreparedStatement statement = conn.prepareStatement(sqlBuilder.toString());

            int parameterIndex = 1;
            if (!playerName.isEmpty()) {
                statement.setString(parameterIndex++, "%" + playerName + "%");
            }
            if (!dateOfBirth.isEmpty()) {
                statement.setString(parameterIndex++, dateOfBirth);
            }
            if (!teamName.isEmpty()) {
                int teamID = getTeamID(teamName);
                statement.setInt(parameterIndex++, teamID);
            }

            ResultSet result = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            tablePlayers.setModel(model);
            model.addColumn("Team");
            model.addColumn("Player Name");
            model.addColumn("Date Of Birth");
            int columnWidth = 680 / 3;
            tablePlayers.getColumnModel().getColumn(0).setPreferredWidth(columnWidth);
            tablePlayers.getColumnModel().getColumn(1).setPreferredWidth(columnWidth);
            tablePlayers.getColumnModel().getColumn(2).setPreferredWidth(columnWidth);

            while (result.next()) {
                String foundTeamName = result.getString("TEAM_NAME");
                String foundPlayerName = result.getString("PLAYER_NAME");
                String foundDateOfBirth = result.getString("DATE_OF_BIRTH");
                model.addRow(new Object[]{foundTeamName, foundPlayerName, foundDateOfBirth});
            }

            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    private int getTeamID(String teamName) {
        Connection conn = DBConnection.getConnection();
        int teamID = -1;
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT TEAM_ID FROM TEAMS WHERE TEAM_NAME = ?");
            statement.setString(1, teamName);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                teamID = result.getInt("TEAM_ID");
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return teamID;
    }
    public void searchStats() {
        String playerName = comboBoxPlayers.getSelectedItem().toString();
        String date = textDate.getText().trim();
        String points = textPoints.getText().trim();
        String assists = textAssists.getText().trim();

        if (playerName.isEmpty() && date.isEmpty() && points.isEmpty() && assists.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter search criteria.");
            return;
        }

        Connection conn = DBConnection.getConnection();

        try {
            StringBuilder sqlBuilder = new StringBuilder("SELECT PLAYERS.PLAYER_NAME, PLAYERSTATISTICS.DATE_, PLAYERSTATISTICS.POINTS, PLAYERSTATISTICS.ASSISTS " +
                    "FROM PLAYERS INNER JOIN PLAYERSTATISTICS " +
                    "ON PLAYERS.PLAYER_ID = PLAYERSTATISTICS.PLAYER_ID WHERE 1=1");

            if (!playerName.isEmpty()) {
                int playerID = getPlayerID(playerName);
                if (playerID != -1) {
                    sqlBuilder.append(" AND PLAYERSTATISTICS.PLAYER_ID = ?");
                } else {
                    JOptionPane.showMessageDialog(null, "Player not found.");
                    return;
                }
            }
            if (!date.isEmpty()) {
                sqlBuilder.append(" AND PLAYERSTATISTICS.DATE_ = ?");
            }
            if (!points.isEmpty()) {
                sqlBuilder.append(" AND PLAYERSTATISTICS.POINTS = ?");
            }
            if (!assists.isEmpty()) {
                sqlBuilder.append(" AND PLAYERSTATISTICS.ASSISTS = ?");
            }

            PreparedStatement statement = conn.prepareStatement(sqlBuilder.toString());

            int parameterIndex = 1;
            if (!playerName.isEmpty()) {
                int playerID = getPlayerID(playerName);
                statement.setInt(parameterIndex++, playerID);
            }
            if (!date.isEmpty()) {
                statement.setString(parameterIndex++, date);
            }
            if (!points.isEmpty()) {
                statement.setInt(parameterIndex++, Integer.parseInt(points));
            }
            if (!assists.isEmpty()) {
                statement.setInt(parameterIndex++, Integer.parseInt(assists));
            }

            ResultSet result = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            tableStats.setModel(model);
            model.addColumn("Player Name");
            model.addColumn("Date");
            model.addColumn("Points");
            model.addColumn("Assists");
            int columnWidth = 680 / 4;
            tableStats.getColumnModel().getColumn(0).setPreferredWidth(columnWidth);
            tableStats.getColumnModel().getColumn(1).setPreferredWidth(columnWidth);
            tableStats.getColumnModel().getColumn(2).setPreferredWidth(columnWidth);
            tableStats.getColumnModel().getColumn(3).setPreferredWidth(columnWidth);

            while (result.next()) {
                String foundPlayerName = result.getString("PLAYER_NAME");
                String foundDate = result.getString("DATE_");
                int foundPoints = result.getInt("POINTS");
                int foundAssists = result.getInt("ASSISTS");
                model.addRow(new Object[]{foundPlayerName, foundDate, foundPoints, foundAssists});
            }

            statement.close();
        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private int getPlayerID(String playerName) {
        Connection conn = DBConnection.getConnection();
        int playerID = -1;
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT PLAYER_ID FROM PLAYERS WHERE PLAYER_NAME = ?");
            statement.setString(1, playerName);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                playerID = result.getInt("PLAYER_ID");
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return playerID;
    }
}
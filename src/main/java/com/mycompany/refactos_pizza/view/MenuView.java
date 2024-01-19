package com.mycompany.refactos_pizza.view;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import com.mycompany.refactos_pizza.controller.MenuController;
import com.mycompany.refactos_pizza.factory.AbstractFactory;
import com.mycompany.refactos_pizza.factory.BigComboFactory;
import com.mycompany.refactos_pizza.factory.GiantComboFactory;
import com.mycompany.refactos_pizza.factory.MediumComboFactory;
import com.mycompany.refactos_pizza.factory.ShortComboFactory;
import com.mycompany.refactos_pizza.model.DrinkItem;
import com.mycompany.refactos_pizza.model.Observer;
import com.mycompany.refactos_pizza.model.PizzaItem;

public class MenuView extends javax.swing.JFrame implements Observer{

    private MenuController menuController = new MenuController();
    private String clientId;

    public MenuView(String clientId) {
        this.clientId = clientId;
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initTable();
        initMenuLists();
        btOrder.addActionListener(e -> createOrder());
        rbShortSize.setSelected(true);
        menuController.addObserver(this);
    }

    private void initMenuLists(){
        var pizzaListModel = new DefaultListModel<PizzaItem>();
        var drinkListModel = new DefaultListModel<DrinkItem>();
        
        pizzaListModel.addAll(menuController.getPizzaItems());
        drinkListModel.addAll(menuController.getDrinkItems());
        ltPizzas.setModel(pizzaListModel);
        ltDrinks.setModel(drinkListModel);

        ltDrinks.setSelectedIndex(0);
        ltPizzas.setSelectedIndex(0);
    }

    @Override
    public void update(long orderId, String size, String status) {
        var orderData = new String[]{String.valueOf(orderId), size, status};

        updateTable(orderData, false);
        appendNotification(clientId + "order's: " + status + "\n");
    }

    private void appendNotification(String notification){
        taNotifications.append(notification);
    }

    private void createOrder(){
        AbstractFactory comboAbstractFactory 
        = 
          rbGiantSize. isSelected() ? new GiantComboFactory()
        : rbMediumSize.isSelected() ? new MediumComboFactory()
        : rbBigSize.   isSelected() ? new BigComboFactory()
        : new ShortComboFactory();

        var pizza = ltPizzas.getSelectedValue();
        var drink = ltDrinks.getSelectedValue();
        var orderData = menuController.createOrder(comboAbstractFactory, pizza, drink, clientId);  
        updateTable(orderData, true);
        appendNotification("You ordered a " + pizza.getName() + " pizza and a " + drink.getName() + " (" + orderData[1] + ")\n");
    }

    private void updateTable(String[] orderData, boolean isAddition){
        var tableModel = (DefaultTableModel)tbPedidos.getModel();
        if(isAddition){
            tableModel.addRow(orderData);
            return;
        }

        for(int i = 0; i < tableModel.getRowCount(); i++){
            if(tableModel.getValueAt(i, 0).equals(orderData[0])){
                tableModel.setValueAt(orderData[2], i, 2);
                return;
            }
        }

    }
    
    private void initTable(){
        tbPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Size", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbShortSize = new javax.swing.JRadioButton();
        rbMediumSize = new javax.swing.JRadioButton();
        rbBigSize = new javax.swing.JRadioButton();
        rbGiantSize = new javax.swing.JRadioButton();
        btOrder = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taNotifications = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        ltPizzas = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ltDrinks = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(rbShortSize);
        rbShortSize.setText("Short");

        buttonGroup1.add(rbMediumSize);
        rbMediumSize.setText("Medium");

        buttonGroup1.add(rbBigSize);
        rbBigSize.setText("Big");

        buttonGroup1.add(rbGiantSize);
        rbGiantSize.setText("Giant");

        btOrder.setText("Order");

        taNotifications.setColumns(20);
        taNotifications.setRows(5);
        jScrollPane3.setViewportView(taNotifications);

        jLabel1.setText("Notifications");

        jLabel2.setText("Orders");

        tbPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order id", "Size", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbPedidos);

        jScrollPane6.setViewportView(ltPizzas);

        jScrollPane1.setViewportView(ltDrinks);

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel3.setText("Escolha seu Combo");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        jLabel4.setText("+");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbShortSize)
                        .addGap(63, 63, 63)
                        .addComponent(rbMediumSize)
                        .addGap(75, 75, 75)
                        .addComponent(rbBigSize)
                        .addGap(77, 77, 77)
                        .addComponent(rbGiantSize))
                    .addComponent(btOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbShortSize)
                    .addComponent(rbMediumSize)
                    .addComponent(rbBigSize)
                    .addComponent(rbGiantSize)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOrder;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JList<DrinkItem> ltDrinks;
    private javax.swing.JList<PizzaItem> ltPizzas;
    private javax.swing.JRadioButton rbBigSize;
    private javax.swing.JRadioButton rbGiantSize;
    private javax.swing.JRadioButton rbMediumSize;
    private javax.swing.JRadioButton rbShortSize;
    private javax.swing.JTextArea taNotifications;
    private javax.swing.JTable tbPedidos;
    // End of variables declaration//GEN-END:variables
}

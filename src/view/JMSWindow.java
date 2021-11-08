package view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;

/**
 *
 * @author Egorov A.
 */
public class JMSWindow extends javax.swing.JFrame {
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JButton jBConnectedListener;
    public javax.swing.JButton jBSendMessage;
    public ButtonGroup buttonGroup_1;
    public ButtonGroup buttonGroup_2;
    public JCheckBox chckbxNewCheckBox;
    private JLabel jLConnected;
    private JLabel jLConnected1;
    private JLabel jLInfSend;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JRadioButton jRBPtP;
    private JRadioButton jRBPubSub;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JSeparator jSeparator1;
    private JSeparator jSeparator3;
    private JTextField jTFNameModel;
    private JTextPane jTPReceivedMess;
    private JTextPane jTPTextMessage;

    public JMSWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // //GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(2, 2, 598, 17);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(12, 30, 147, 14);
        jTFNameModel = new javax.swing.JTextField();
        jTFNameModel.setBounds(12, 50, 234, 20);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBounds(12, 76, 90, 14);
        jRBPtP = new javax.swing.JRadioButton();
        jRBPtP.setBounds(12, 92, 95, 23);
        jRBPubSub = new javax.swing.JRadioButton();
        jRBPubSub.setBounds(115, 92, 151, 23);
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator1.setBounds(12, 117, 578, 10);
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setBounds(12, 206, 110, 14);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(12, 231, 578, 87);
        jTPTextMessage = new javax.swing.JTextPane();
        jBSendMessage = new javax.swing.JButton();
        jBSendMessage.setBounds(12, 329, 177, 23);
        jLConnected = new javax.swing.JLabel();
        jLConnected.setBounds(250, 53, 185, 14);
        jLInfSend = new javax.swing.JLabel();
        jLInfSend.setBounds(163, 251, 0, 0);
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jBConnectedListener = new javax.swing.JButton();
        jLConnected1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTPReceivedMess = new javax.swing.JTextPane();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Отправка сообщения JMS провайдеру");
        jLabel1.setToolTipText("");

        jLabel2.setText("Имя очереди/подписки");

        jTFNameModel.setText("SimpleQueue");
        jTFNameModel.setToolTipText("");
        jTFNameModel.setNextFocusableComponent(jRBPtP);

        jLabel3.setText("Вид модели");

        buttonGroup1.add(jRBPtP);
        jRBPtP.setSelected(true);
        jRBPtP.setText("точка-точка");
        jRBPtP.setToolTipText("");
        jRBPtP.setNextFocusableComponent(jRBPubSub);

        buttonGroup1.add(jRBPubSub);
        jRBPubSub.setText("подписчик/издатель");
        jRBPubSub.setToolTipText("");
        jRBPubSub.setNextFocusableComponent(jTPTextMessage);

        jLabel4.setText("Текст сообщения");
        jLabel4.setToolTipText("");

        jTPTextMessage.setNextFocusableComponent(jBSendMessage);
        jScrollPane1.setViewportView(jTPTextMessage);

        jBSendMessage.setText("Отправить сообщение");

        jLConnected.setText("Соединение не установлено");

        jLInfSend.setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Получение сообщений от JMS провайдера");

        jBConnectedListener.setText("Подключить слушатель");

        jLConnected1.setText("Соединение не установлено");

        jLabel7.setText("Полученные сообщения:");
        jLabel7.setToolTipText("");

        jTPReceivedMess.setEditable(false);
        jScrollPane2.setViewportView(jTPReceivedMess);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(168, 168, 168)
                                                                .addComponent(jLabel5))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jBConnectedListener)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLConnected1))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel7)))
                                                .addGap(0, 144, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBConnectedListener)
                                        .addComponent(jLConnected1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(jPanel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                                        .addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                                .addGap(18)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1.setLayout(null);
        jPanel1.add(jLabel1);
        jPanel1.add(jSeparator1);
        jPanel1.add(jScrollPane1);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel4);
        jPanel1.add(jBSendMessage);
        jPanel1.add(jLInfSend);
        jPanel1.add(jTFNameModel);
        jPanel1.add(jRBPtP);
        jPanel1.add(jRBPubSub);
        jPanel1.add(jLConnected);

        JLabel lblNewLabel_1 = new JLabel("Настройки сессии");
        lblNewLabel_1.setBounds(12, 127, 117, 14);
        jPanel1.add(lblNewLabel_1);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("TRANSACTED");
        rdbtnNewRadioButton_1.setActionCommand("0");
        rdbtnNewRadioButton_1.setBounds(142, 123, 117, 23);
        jPanel1.add(rdbtnNewRadioButton_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("AUTO_ACK", true);
        rdbtnNewRadioButton_2.setActionCommand("1");
        rdbtnNewRadioButton_2.setBounds(261, 123, 99, 23);
        jPanel1.add(rdbtnNewRadioButton_2);

        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("CLIENT_ACK");
        rdbtnNewRadioButton_3.setActionCommand("2");
        rdbtnNewRadioButton_3.setBounds(362, 123, 110, 23);
        jPanel1.add(rdbtnNewRadioButton_3);

        JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("DUPS_OK_ACK");
        rdbtnNewRadioButton_4.setActionCommand("3");
        rdbtnNewRadioButton_4.setBounds(474, 123, 122, 23);
        jPanel1.add(rdbtnNewRadioButton_4);

        buttonGroup_1 = new ButtonGroup();
        buttonGroup_1.add(rdbtnNewRadioButton_1);
        buttonGroup_1.add(rdbtnNewRadioButton_2);
        buttonGroup_1.add(rdbtnNewRadioButton_3);
        buttonGroup_1.add(rdbtnNewRadioButton_4);

        JLabel lblNewLabel_2 = new JLabel("Тип сообщения");
        lblNewLabel_2.setBounds(10, 163, 99, 14);
        jPanel1.add(lblNewLabel_2);

        JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("PERSISTENT", true);
        rdbtnNewRadioButton_5.setActionCommand("2");
        rdbtnNewRadioButton_5.setBounds(142, 159, 109, 23);
        jPanel1.add(rdbtnNewRadioButton_5);

        JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("NON_PERSISTENT");
        rdbtnNewRadioButton_6.setActionCommand("1");
        rdbtnNewRadioButton_6.setBounds(261, 159, 134, 23);
        jPanel1.add(rdbtnNewRadioButton_6);

        buttonGroup_2 = new ButtonGroup();
        buttonGroup_2.add(rdbtnNewRadioButton_5);
        buttonGroup_2.add(rdbtnNewRadioButton_6);

        chckbxNewCheckBox = new JCheckBox("Embedded broker");
        chckbxNewCheckBox.setBounds(426, 47, 97, 23);
        jPanel1.add(chckbxNewCheckBox);

        getContentPane().setLayout(layout);
        pack();
    }// //GEN-END:initComponents


    public void toggleSendConnected(){
        if (this.jLConnected.getText().equals("Соединение не установлено")){
            this.jLConnected.setText("Соединение установлено");
            this.jLConnected.setForeground(Color.green);
        }else{
            this.jLConnected.setText("Соединение не установлено");
            this.jLConnected.setForeground(Color.black);
        }
    }

    public void SendConnectedSucces(){
        this.jLConnected.setText("Соединение установлено");
        this.jLConnected.setForeground(Color.green);
    }

    public void toggleReceivedConnected(){
        if (this.jLConnected1.getText().equals("Соединение не установлено")){
            this.jLConnected1.setText("Соединение установлено");
            this.jLConnected1.setForeground(Color.green);
        }else{
            this.jLConnected1.setText("Соединение не установлено");
            this.jLConnected1.setForeground(Color.black);
        }
    }
    public void ReceivedConnectedSucces(){
        this.jLConnected1.setText("Соединение установлено");
        this.jLConnected1.setForeground(Color.green);
    }
    public void ReceivedConnectedClose(){
        this.jLConnected1.setText("Соединение не установлено");
        this.jLConnected1.setForeground(Color.black);
    }
    /**
     * Возвращает имя очереди или подписки, которой необходимо отправить сообщение.
     * @return
     */
    public String getQueueSendName(){
        return this.jTFNameModel.getText();
    }
    public void setTextReceiver(String text){
        this.jTPReceivedMess.setText(this.jTPReceivedMess.getText()+"\n"+text);

    }
    /**
     * Возвращает текст для отправки.
     * @return
     */
    public String getMessageSendText(){
        return this.jTPTextMessage.getText();
    }
    /**
     * Выбрана ли модель подключения точка-точка?
     * @return
     */
    public Boolean isPtP(){
        return jRBPtP.isSelected();
    }
    /**
     * Выбрана ли модель подключения подписчик\издатель?
     * @return
     */
    public Boolean isPupSub(){
        return jRBPubSub.isSelected();
    }
    public void SendSuccess(){
        this.jLInfSend.setText("Сообщение успешно отправлено");
        this.jLInfSend.setForeground(Color.green);
    }
    public void SendError(){
        this.jLInfSend.setText("Сообщение не удалось отправить");
        this.jLInfSend.setForeground(Color.red);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.itcast_03;

import cn.itcast.util.MyLookAndFeel;
import cn.itcast.util.UiUtil;
import cn.itcast_02.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author fqy
 */
public class OperatorJFrame extends javax.swing.JFrame {

    /**
     * Creates new form OperatorJFrame
     */
    public OperatorJFrame() {
        initComponents();
        init();
    }
    
    private  void init() {
        this.setTitle("模拟四则运算");
        UiUtil.setFrameIcon(this, "src\\cn\\itcast\\resource\\jjcc.jpg");
        UiUtil.setFrameCenter(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        firstNumber = new javax.swing.JTextField();
        choiceOperator = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        secondNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        resultNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jiSuanButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("第一个操作数");

        choiceOperator.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+", "-", "*", "/" }));

        jLabel2.setText("第二个操作数");

        jLabel3.setText("=");

        jLabel4.setText("结果");

        jiSuanButton.setText("计算");
        jiSuanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jiSuanButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(firstNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(choiceOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jiSuanButton)
                    .addComponent(resultNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choiceOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(resultNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jiSuanButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jiSuanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jiSuanButtonMouseClicked
        /*
         思路：
         1:获取操作数和运算符
         2:根据运算符，进行相应的运算
         3:把运算的结果赋值给最后一个文本框
         */
        String firstNumberString = this.firstNumber.getText();
        String operatorString = String.valueOf(this.choiceOperator.getSelectedItem());
        String secondNumberString = this.secondNumber.getText();

        //加入数据校验
        String regex = "\\d+";

        if (!firstNumberString.matches(regex)) {
//            System.out.println("你输入的数据有误");
            //弹出一个框框
            // public static void showMessageDialog(Component parentComponent,Object message)
            JOptionPane.showMessageDialog(this, "第一个操作数不是数字");
            this.firstNumber.setText("");
            //获得焦点
            this.firstNumber.requestFocus();
            return;
        }

        if (!secondNumberString.matches(regex)) {
            JOptionPane.showMessageDialog(this, "第二个操作数不是数字");
            this.secondNumber.setText("");
            //获得焦点
            this.secondNumber.requestFocus();
            return;
        }

        //把字符串转换为数据类型
        int firstNumber = Integer.parseInt(firstNumberString);
        int secondNumber = Integer.parseInt(secondNumberString);

        //定义变量，用于保存运算的结果
        int result = 0;

        switch (operatorString) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                     JOptionPane.showMessageDialog(this, "除数不能为0");
                    //获得焦点
                    this.secondNumber.requestFocus();
                    return;
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
        }

        //把运算的结果赋值给最后一个文本框
        this.resultNumber.setText(String.valueOf(result));
    }//GEN-LAST:event_jiSuanButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OperatorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperatorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperatorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperatorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            //修改皮肤
            UIManager.setLookAndFeel(MyLookAndFeel.LIQUIDINF);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperatorJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(OperatorJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OperatorJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(OperatorJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OperatorJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox choiceOperator;
    private javax.swing.JTextField firstNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jiSuanButton;
    private javax.swing.JTextField resultNumber;
    private javax.swing.JTextField secondNumber;
    // End of variables declaration//GEN-END:variables
}

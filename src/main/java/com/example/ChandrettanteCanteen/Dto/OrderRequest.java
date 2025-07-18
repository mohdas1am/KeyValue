package com.example.ChandrettanteCanteen.Dto;

public class OrderRequest {

    private String studentId;   // student placing the order
    private String itemId;      // menu item being ordered
    private String paymentType; // "pay_now" or "on_account"

    // Constructors (optional)
    public OrderRequest() { }

    public OrderRequest(String studentId, String itemId, String paymentType) {
        this.studentId = studentId;
        this.itemId = itemId;
        this.paymentType = paymentType;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}



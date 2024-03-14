package edu.com.java5_asm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    private Date createDate = new Date();
    @ManyToOne
    @JoinColumn(name = "Username")
    private Account account;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
    @Column(name = "CheckOut")
    private boolean checkOut;
    private boolean status;
}

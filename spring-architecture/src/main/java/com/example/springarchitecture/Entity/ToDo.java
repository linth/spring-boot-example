// package com.example.springarchitecture.Entity;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;
// import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.annotation.LastModifiedDate;
// import java.util.Date;
// import lombok.Data;
// @Entity
// @Table
// @Data
// public class ToDo {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     Integer id;
//     @Column
//     String task = "";
//     @Column(insertable = false, columnDefinition = "int default 1")
//     Integer status = 1;
//     @CreatedDate
//     @Column(updatable = false, nullable = false)
//     Date createTime = new Date();
//     @LastModifiedDate
//     @Column(nullable = false)
//     Date updateTime = new Date();
//     public void setId(Integer id) {
//         this.id = id;
//     }
//     public void setTask(String task) {
//         this.task = task;
//     }
//     public void setStatus(Integer status) {
//         this.status = status;
//     }
//     public void setCreateTime(Date createTime) {
//         this.createTime = createTime;
//     }
//     public void setUpdateTime(Date updateTime) {
//         this.updateTime = updateTime;
//     }
// }

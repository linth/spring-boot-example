// package com.example.springarchitecture.Dto;

// import lombok.Data;

/**
 * DTO（Data Transfer Object）：資料傳輸物件
 *  - 比如一張表有100個欄位，那么對應的PO就有100個屬性，但是我們界面上只要顯示10個欄位，客戶端用WEB service 來獲取資料，沒必要把整個PO物件傳到客戶端，這時我們就可以用只有這10個屬性的DTO來傳遞到客戶端，這樣也不會暴露服務端表結構
 * 
 * Reference:
 *  - https://www.uj5u.com/ruanti/282608.html
 */


// @Data
// public class DtoPerson {
    
// }

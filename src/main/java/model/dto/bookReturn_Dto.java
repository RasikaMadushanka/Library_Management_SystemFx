package model.dto;

public class bookReturn_Dto {
    private String returnId;      // Unique ID
    private String rentId;        // Rental reference

    private String customerId;    // Customer returning
    private String bookId;        // Book returned

    private String returnDate;    // Actual return date
    private double fine;          // Total fine (late fee + extra fee)
    private double bookPrice;     // For lost/damage fee

    private int lateDays;         // How many days late?
    private double extraFee;      // Additional penalty if very late
    private double dailyLateFee;  // Per-day fee for late return

    private String status;        // RETURNED / LATE_RETURNED / LOST
}

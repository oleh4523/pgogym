public abstract class MembershipPlan implements Billable {
    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    public String getPlanCode() {
        return planCode;
    }
    public String getClientName() {
        return clientName;
    }
    public int getMonths() {
        return months;
    }
    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }
    public boolean isAutoRenew() {
        return autoRenew;
    }

    public abstract String getPlanType();

    public abstract double calculateMonthlyNetPrice();


    @Override
    public double calculateMonthlyGrossPrice() {
        return calculateMonthlyNetPrice() * 1.23; // 23% VAT
    }

    public double calculateTotalNetPrice() {
        return calculateMonthlyNetPrice() * months;
    }

    public final void printSummary() {
        System.out.println("Plan code: " + planCode);
        System.out.println("Client: " + clientName);
        System.out.println("Plan type: " + getPlanType());
        System.out.println("Duration (months): " + months);
        System.out.println("Monthly net: " + calculateMonthlyNetPrice());
        System.out.println("Monthly gross: " + calculateMonthlyGrossPrice());
        System.out.println("Total contract net: " + calculateTotalNetPrice());
    }

    @Override
    public String toString() {
        return getPlanType() + " [planCode=" + planCode + ", clientName=" + clientName + ", months=" + months + "]";
    }



}
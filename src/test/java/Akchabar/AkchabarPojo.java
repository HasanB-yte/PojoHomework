package Akchabar;

import java.util.List;

public class AkchabarPojo {

    private String date;
    private Rates rates;
    private long updated_at;




    public String getDate() {
        return date;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public void setDate(String date) {
        this.date = date;


    }
}

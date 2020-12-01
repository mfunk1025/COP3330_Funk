public class ContactItem {
    protected String fname;
    protected String lname;
    protected String phone;
    protected String email;

    public ContactItem(String fname, String lname, String phone, String email){
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
    }

    public String getFname(){
        return fname;
    }

    public String getLname(){
        return lname;
    }

    public String getname(){
        return (fname + " " + lname);
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEmail(String email){

        this.email = email;
    }
}

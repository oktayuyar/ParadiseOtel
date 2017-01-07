package otelpackage;

import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;


public class NewClass implements PhaseListener{
private String kullaniciadi="";
private String sifre;
private String kullanicias;

    @Override
    public void afterPhase(PhaseEvent event) {
        ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session=(HttpSession) ec.getSession(true);
        kullaniciadi=(String) session.getAttribute("kullaniciadi");
        if(kullaniciadi==null)
            kullaniciadi="";
        System.out.println("kullanıcı : "+kullaniciadi);
        FacesContext cont = event.getFacesContext();
        String page = cont.getViewRoot().getViewId(); //gidilecek sayfanın ismi page değişkenine yüklendi
        if(kullaniciadi.equals(""))
        {
            if(page.lastIndexOf("admin/")>-1)
            {
                NavigationHandler nav = cont.getApplication().getNavigationHandler();
                nav.handleNavigation(cont, null, "/login");
                System.out.println("logine gitmem lazım kullanıcı : "+kullaniciadi);
            }
        }

    }

    @Override
    public void beforePhase(PhaseEvent event) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getKullanicias() {
        return kullanicias;
    }

    public void setKullanicias(String kullanicias) {
        this.kullanicias = kullanicias;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
}

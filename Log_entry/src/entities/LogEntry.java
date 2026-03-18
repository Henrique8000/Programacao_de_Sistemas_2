package entities;
public class LogEntry {

    private String ip;
    private String data;
    private String  metodo;
    private String  url;
    private int status;
    private long latencia;

    public LogEntry(String linha) {
        String partes [] = linha.split("\\|");
        this.ip = partes[0];
        this.data = partes[1];
        this.metodo = partes[2];
        this.url = partes[3].trim();
        this.status = Integer.parseInt(partes[4].trim());
        this.latencia = Integer.parseInt(partes[5].trim().replace("ms", "")) ;
    }
    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "LogEntry [ip=" + ip + ", data=" + data + ", metodo=" + metodo + ", url=" + url + ", status=" + status
                + ", latencia=" + latencia + "]";
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getMetodo() {
        return metodo;
    }
    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public long getLatencia() {
        return latencia;
    }
    public void setLatencia(long latencia) {
        this.latencia = latencia;
    }

}

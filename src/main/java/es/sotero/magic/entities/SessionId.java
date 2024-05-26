package es.sotero.magic.entities;

import java.io.Serializable;
import java.util.Objects;

public class SessionId implements Serializable {

    private Integer id;
    private String computerName;

    public SessionId() {}

    public SessionId(Integer id, String computerName) {
        this.id = id;
        this.computerName = computerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionId sessionId = (SessionId) o;
        return Objects.equals(id, sessionId.id) && Objects.equals(computerName, sessionId.computerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, computerName);
    }
}
package ucab.ingsw.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString

public class Album  implements Serializable {
    @Id
    private long album_id;
    private long user_id;
    private String album_name;
    private List<Long> content = new ArrayList<>();
    private String album_purpose;
        
     public long getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(long album_id) {
        this.album_id = album_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public List<Long> getContent() {
        return content;
    }

    public void setContent(List<Long> content) {
        this.content = content;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getAlbum_purpose() {
        return album_purpose;
    }

    public void setAlbum_purpose(String album_purpose) {
        this.album_purpose = album_purpose;
    }
}

    
    
}

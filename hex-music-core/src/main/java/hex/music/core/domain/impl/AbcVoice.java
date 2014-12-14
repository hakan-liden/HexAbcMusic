package hex.music.core.domain.impl;

import hex.music.core.domain.Clef;
import hex.music.core.domain.MetaData;
import hex.music.core.domain.Voice;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author hln
 */
@Entity
@Table(name = "Voice")
public class AbcVoice implements Voice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String shortName;
    @Column
    private String code;
    @Column
    private String body;
    @Column
    private int voiceIndex;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "voice", targetEntity = AbcClef.class)
    private Clef clef;
    @OneToOne
    private MetaData metaData;
    

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }
    
    @Override
    public int getVoiceIndex() {
        return voiceIndex;
    }

    @Override
    public void setVoiceIndex(int index) {
        this.voiceIndex = index;
    }

    @Override
    public Clef getClef() {
        return clef;
    }

    @Override
    public void setClef(Clef clef) {
        this.clef = clef;
    }

    @Override
    public MetaData getMetaData() {
        return metaData;
    }

    @Override
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }
}

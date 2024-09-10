package domtorres.harmonize.models;

import java.time.LocalDateTime;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Node
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

    @Id @GeneratedValue
    private Long id;

    private String content;

    private LocalDateTime timestamp;

    private Status status;

    @Relationship(type = "SEND_BY", direction = Relationship.Direction.INCOMING)
    private User sender;

    @Relationship(type = "SENT_TO", direction = Relationship.Direction.OUTGOING)
    private User recipient;
}

package ma.enset.ahlamchakrane_activitepratique1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerRequestDTO {
	private String id;
	private String name;
	private String email;
}
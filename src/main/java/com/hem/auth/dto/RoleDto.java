package com.hem.auth.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RoleDto {

		private String id;
	    @NotBlank
	    @Size(max = 20)
	    private String name;
	    
	    private boolean enabled;

	    private List<Short> privilege;
	    
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public List<Short> getPrivilege() {
			return privilege;
		}

		public void setPrivilege(List<Short> privilege) {
			this.privilege = privilege;
		}
	    
	    
	    
	    
}

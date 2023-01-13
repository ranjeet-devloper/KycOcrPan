package com.kyc.entity;

import com.kyc.common.Date;
import com.kyc.common.DateOfIssue;
import com.kyc.common.Father;
import com.kyc.common.Name;
import com.kyc.common.PanNO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Details {
	private PanNO panNo;
	private Name name;
	private Father fatherName;
	private Date date;
	private DateOfIssue dateOfIssue;
}

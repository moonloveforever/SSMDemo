package com.zxl.soft.branch.service;

import com.zxl.soft.branch.entity.Branch;

public interface BranchService {
	public Branch getBranchById(String id);
	public Branch deleteBranch(String id);
	public Branch getBranchList();
	public Branch updateBranch(String id);
}

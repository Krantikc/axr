package com.axr.dao;

import java.util.List;

import com.axr.model.Block;

public interface BlockDAO {
	public boolean updateBlock(Block block);
	public int createBlock(Block block);
	public List<Block> getBlocks();
}

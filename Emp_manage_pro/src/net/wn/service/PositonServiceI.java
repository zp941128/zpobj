package net.wn.service;

import java.util.List;

import net.wn.entity.PositionP;
import net.wn.vo.PositionVo;


public interface PositonServiceI {
	List<PositionP> findAll() throws Exception;
	List<PositionVo> findPosition() throws Exception;
}

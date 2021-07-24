package com.example.oa.mapper;

import com.example.oa.entity.Notice;
import com.example.oa.utils.MybatisUtils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class NoticeMapperTest {

	@Test
	public void insert() {
		MybatisUtils.executeUpdate(sqlSession -> {
			NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
			mapper.insert(new Notice(2l, "test"));
			return null;
		});
	}
}
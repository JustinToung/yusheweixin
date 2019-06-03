package cn.java.entity;

import lombok.Data;
/**
 * 社区实体类
 * @author LIXIAOWANG
 *
 */
@Data
public class CommunityInfoEntity {
	private int id;//社区id
	private String communityName;//社区名称
	private String communityAddress;//社区地址
	private String communityImage;//社区图片
	private String communityExplain;//社区说明
}

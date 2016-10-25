package com.web.model;

import com.web.entities.Notice;

public class NoticeModel extends Notice {
   private String cmtCnt;

   public String getCmtCnt() {
      return cmtCnt;
   }

   public void setCmtCnt(String cmtCnt) {
      this.cmtCnt = cmtCnt;
   }
   

}
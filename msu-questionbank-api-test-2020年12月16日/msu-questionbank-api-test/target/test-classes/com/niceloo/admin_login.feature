Feature: 智能运营平台登录

#  -- 4265C95E185C46CCA131EDAB7A0BEFED
  Scenario: 试题分类列表-正常
    Given URL "http://umsacheck.niceloo.com/api/qb/papertype/profile/list"
    When Get


  Scenario: 试题分类列表-异常
    Given URL "http://umsacheck.niceloo.com/api/qb/papertype/profile/list1"
    When Get





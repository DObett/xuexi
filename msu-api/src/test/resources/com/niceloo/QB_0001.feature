Feature: 科目列表-QB_0001
  1. 科目类型格式不正确

#  Scenario: 科目类型格式不正确
#    Given 科目专业类型状态 "11"
#    When 发起接口测试
#    Then 断言 "result"="GB2001"
#
#  Scenario: 科目展示状态不正确
#    Given 科目专业类型状态 "123123"
#    And 科目展示状态 "11"
#    And URL ""
#    When 发起接口测试
#    Then 断言 "result"="000000"

  Scenario: 科目详情
    Given 科目ID "1"
    And URL "http://umsacheck.niceloo.com/api/qb/subject/info"
    When GET
    Then Assert
Feature: 科目列表-QB_0001
  1. 科目类型格式不正确

  Scenario: 科目类型格式不正确
    Given 科目专业类型状态 "11"
    When 发起接口测试
    Then 断言 "result"="GB2001"

  Scenario: 科目类型格式不正确
    Given 科目专业类型状态 "123123"
    And 科目展示状态 "11"
    When 发起接口测试
    Then 断言 "result"="000000"
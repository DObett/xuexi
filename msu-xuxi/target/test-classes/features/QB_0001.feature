Feature: 科目列表-QB_0001
  1. 科目类型格式不正确

  Scenario Outline: 科目类型格式不正确
    Given 科目专业类型状态 "https://tool.lu/timestamp/"
    When Get
    Then 断言

    Then JSONPATH_ASSERT "<jsonPath>" equals "<value>"

    Then JSONPATH_GET_MONGO
      | data.token | token |
      | data.userId | userId |
    Examples:
      | jsonPath | value  |
      | .main-doc > h3:nth-child(1)   | 获取当前时间戳 |




#  Scenario: 科目类型格式不正确
#    Given 科目专业类型状态 "123123"
#    And 科目展示状态 "11"
#    When 发起接口测试22
#    Then 断言 "result"="000000"
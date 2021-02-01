Feature:A001


  Scenario Outline: A001
    Given 网址 "https://tool.lu/timestamp/"
    When Get




#    Then JSONPATH_GET_MONGO
#      | data.token | token |
#      | data.userId | userId |
    Then JSONPATH_ASSERT "<jsonPath>" equals "<value>"
    Examples:
      | jsonPath | value  |
      | .main-doc > h3:nth-child(1)  | 获取当前时间戳 |

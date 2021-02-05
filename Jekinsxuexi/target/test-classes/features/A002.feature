Feature:A002


  Scenario Outline: A002
    Given API "/api/ir/org/item/view/list"
    When Get
    And Param
	 """
	 pageIndex : 700
	 pageSize : 100
	 orderNo :
	 userId :
	 projectId :
	 schoolId :
	 orderType :
	 itemdtlAimdatestart :
	 itemdtlAimdateend :


	 """



#    Then JSONPATH_GET_MONGO
#      | data.token | token |
#      | data.userId | userId |
    Then JSONPATH_ASSERT "<jsonPath>" equals "<value>"
    Examples:
      | jsonPath | value  |
      | result   | 000000 |

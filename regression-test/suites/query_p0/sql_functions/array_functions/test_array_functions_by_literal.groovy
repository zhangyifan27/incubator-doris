// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

suite("test_array_functions_by_literal") {
    // array_contains function
    qt_sql "select array_contains([1,2,3], 1)"
    qt_sql "select array_contains([1,2,3], 4)"
    qt_sql "select array_contains([1,2,3,NULL], 1)"
    qt_sql "select array_contains([1,2,3,NULL], NULL)"
    qt_sql "select array_contains([], 1)"
    qt_sql "select array_contains([], NULL)"
    qt_sql "select array_contains(NULL, 1)"
    qt_sql "select array_contains(NULL, NULL)"
    qt_sql "select array_contains([true], false)"
    qt_sql "select array_contains(array(cast ('2023-02-04 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))), cast ('2023-02-04 22:07:34.999' as datetimev2(3)))"
    qt_sql "select array_contains(array(cast ('2023-02-04' as datev2),cast ('2023-02-05' as datev2)), cast ('2023-02-05' as datev2))"

    // array_position function
    qt_sql "select array_position([1,2,3], 1)"
    qt_sql "select array_position([1,2,3], 3)"
    qt_sql "select array_position([1,2,3], 4)"
    qt_sql "select array_position([NULL,2,3], 2)"
    qt_sql "select array_position([NULL,2,3], NULL)"
    qt_sql "select array_position([], 1)"
    qt_sql "select array_position([], NULL)"
    qt_sql "select array_position(NULL, 1)"
    qt_sql "select array_position(NULL, NULL)"
    qt_sql "select array_position([null], 0)"
    qt_sql "select array_position([0], null)"
    qt_sql "select array_position([null, '1'], '')"
    qt_sql "select array_position([''], null)"
    qt_sql "select array_position([false, NULL, true], true)"
    qt_sql "select array_position(array(cast ('2023-02-04 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))), cast ('2023-02-04 22:07:34.999' as datetimev2(3)))"
    qt_sql "select array_position(array(cast ('2023-02-04' as datev2),cast ('2023-02-05' as datev2)), cast ('2023-02-05' as datev2))"

    // element_at function
    qt_sql "select element_at([1,2,3], 1)"
    qt_sql "select element_at([1,2,3], 3)"
    qt_sql "select element_at([1,2,3], 4)"
    qt_sql "select element_at([1,2,3], -1)"
    qt_sql "select element_at([1,2,3], NULL)"
    qt_sql "select element_at([1,2,NULL], 3)"
    qt_sql "select element_at([1,2,NULL], 2)"
    qt_sql "select element_at([], -1)"
    qt_sql "select element_at([true, NULL, false], 2)"
    qt_sql "select element_at(array(cast ('2023-02-04 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))), 1)"
    qt_sql "select element_at(array(cast ('2023-02-04' as datev2),cast ('2023-02-05' as datev2)), 2)"

    // array subscript function
    qt_sql "select [1,2,3][1]"
    qt_sql "select [1,2,3][3]"
    qt_sql "select [1,2,3][4]"
    qt_sql "select [1,2,3][-1]"
    qt_sql "select [1,2,3][NULL]"
    qt_sql "select [1,2,NULL][3]"
    qt_sql "select [1,2,NULL][2]"
    qt_sql "select [][-1]"
    qt_sql "select [true, false]"
    qt_sql "select (array(cast ('2023-02-04 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))[2]"
    qt_sql "select (array(cast ('2023-02-04' as datev2),cast ('2023-02-05' as datev2)))[2]"

    // array_aggregation function
    qt_sql "select array_avg([1,2,3])"
    qt_sql "select array_sum([1,2,3])"
    qt_sql "select array_min([1,2,3])"
    qt_sql "select array_max([1,2,3])"
    qt_sql "select array_product([1,2,3])"
    qt_sql "select array_avg([1,2,3,null])"
    qt_sql "select array_sum([1,2,3,null])"
    qt_sql "select array_min([1,2,3,null])"
    qt_sql "select array_max([1,2,3,null])"
    qt_sql "select array_product([1,2,3,null])"
    qt_sql "select array_avg([])"
    qt_sql "select array_sum([])"
    qt_sql "select array_min([])"
    qt_sql "select array_max([])"
    qt_sql "select array_product([])"
    qt_sql "select array_avg([null])"
    qt_sql "select array_sum([null])"
    qt_sql "select array_min([null])"
    qt_sql "select array_max([null])"
    qt_sql "select array_product([null])"
    qt_sql "select array_product([1.12, 3.45, 4.23])"
    qt_sql "select array_product([1.12, 3.45, -4.23])"
    qt_sql "select array_min(array(cast ('2023-02-04 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))"
    qt_sql "select array_max(array(cast ('2023-02-04 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))"
    qt_sql "select array_min(array(cast ('2023-02-04' as datev2),cast ('2023-02-05' as datev2)))"
    qt_sql "select array_max(array(cast ('2023-02-04' as datev2),cast ('2023-02-05' as datev2)))"

    // array_distinct function
    qt_sql "select array_distinct([1,1,2,2,3,3])"
    qt_sql "select array_distinct([1,1,2,2,3,3,null])"
    qt_sql "select array_distinct([1,1,3,3,null, null, null])"
    qt_sql "select array_distinct(['a','a','a'])"
    qt_sql "select array_distinct([null, 'a','a','a', null])"
    qt_sql "select array_distinct([true, false, false, null])"
    qt_sql "select array_distinct([])"
    qt_sql "select array_distinct([null,null])"
    qt_sql "select array_distinct([1, 0, 0, null])"
    qt_sql "select array_distinct(array(cast ('2023-02-04 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))"
    qt_sql "select array_distinct(array(cast ('2023-02-04' as datev2),cast ('2023-02-05' as datev2),cast ('2023-02-05' as datev2)))"


    // array_remove function
    qt_sql "select array_remove([1,2,3], 1)"
    qt_sql "select array_remove([1,2,3,null], 1)"
    qt_sql "select array_remove(['a','b','c'], 'a')"
    qt_sql "select array_remove(['a','b','c',null], 'a')"
    qt_sql "select array_remove([true, false, false], false)"
    qt_sql "select array_remove(array(cast ('2023-02-04 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))), cast ('2023-02-04 22:07:34.999' as datetimev2(3)))"
    qt_sql "select array_remove(array(cast ('2023-02-04' as datev2),cast ('2023-02-05' as datev2)), cast ('2023-02-05' as datev2))"
 
    // array_sort function
    qt_sql "select array_sort([1,2,3])"
    qt_sql "select array_sort([3,2,1])"
    qt_sql "select array_sort([1,2,3,null])"
    qt_sql "select array_sort([null,1,2,3])"
    qt_sql "select array_sort(['a','b','c'])"
    qt_sql "select array_sort(['c','b','a'])"
    qt_sql "select array_sort([true, false, true])"
    qt_sql "select array_sort([])"
    qt_sql "select array_sort(array(cast ('2023-02-06 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))"
    qt_sql "select array_sort(array(cast ('2023-02-06' as datev2),cast ('2023-02-05' as datev2)))"

    // array_overlap function
    qt_sql "select arrays_overlap([1,2,3], [4,5,6])"
    qt_sql "select arrays_overlap([1,2,3], [3,4,5])"
    qt_sql "select arrays_overlap([1,2,3,null], [3,4,5])"
    qt_sql "select arrays_overlap([true], [false])"
    qt_sql "select arrays_overlap([], [])"
    qt_sql "select arrays_overlap(array(cast ('2023-02-06 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))),array(cast ('2023-02-07 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))"
    qt_sql "select arrays_overlap(array(cast ('2023-02-06 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))),array(cast ('2023-02-07 22:07:34.999' as datetimev2(3)),cast ('2023-02-08 23:07:34.999' as datetimev2(3))))"
    qt_sql "select arrays_overlap(array(cast ('2023-02-06' as datev2), cast ('2023-02-05' as datev2)), array(cast ('2023-02-07' as datev2), cast ('2023-02-05' as datev2)))"
    qt_sql "select arrays_overlap(array(cast ('2023-02-06' as datev2), cast ('2023-02-05' as datev2)), array(cast ('2023-02-07' as datev2), cast ('2023-02-08' as datev2)))"

    // array_binary function
    qt_sql "select array_union([1,2,3], [2,3,4])"
    qt_sql "select array_except([1,2,3], [2,3,4])"
    qt_sql "select array_intersect([1,2,3], [2,3,4])"
    qt_sql "select array_union([1,2,3], [2,3,4,null])"
    qt_sql "select array_except([1,2,3], [2,3,4,null])"
    qt_sql "select array_intersect([1,2,3], [2,3,4,null])"
    qt_sql "select array_union([true], [false])"
    qt_sql "select array_except([true, false], [true])"
    qt_sql "select array_intersect([false, true], [false])"
    qt_sql "select array_union([], [])"
    qt_sql "select array_except([], [])"
    qt_sql "select array_intersect([], [])"
    qt_sql "select array_union([], [1,2,3])"
    qt_sql "select array_except([], [1,2,3])"
    qt_sql "select array_intersect([], [1,2,3])"
    qt_sql "select array_union([null], [1,2,3])"
    qt_sql "select array_except([null], [1,2,3])"
    qt_sql "select array_intersect([null], [1,2,3])"
    qt_sql "select array_union([1], [100000000])"
    qt_sql "select array_except([1], [100000000])"
    qt_sql "select array_intersect([1], [100000000])"
    qt_sql "select array_union(array(cast ('2023-02-06 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))),array(cast ('2023-02-07 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))"
    qt_sql "select array_except(array(cast ('2023-02-06 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))),array(cast ('2023-02-07 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))"
    qt_sql "select array_intersect(array(cast ('2023-02-06 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))),array(cast ('2023-02-07 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))"
    qt_sql "select array_union(array(cast ('2023-02-06' as datev2), cast ('2023-02-05' as datev2)), array(cast ('2023-02-07' as datev2), cast ('2023-02-05' as datev2)))"
    qt_sql "select array_except(array(cast ('2023-02-06' as datev2), cast ('2023-02-05' as datev2)), array(cast ('2023-02-07' as datev2), cast ('2023-02-05' as datev2)))"
    qt_sql "select array_intersect(array(cast ('2023-02-06' as datev2), cast ('2023-02-05' as datev2)), array(cast ('2023-02-07' as datev2), cast ('2023-02-05' as datev2)))"

    // array_slice function
    qt_sql "select [1,2,3][1:1]"
    qt_sql "select [1,2,3][1:3]"
    qt_sql "select [1,2,3][1:5]"
    qt_sql "select [1,2,3][2:]"
    qt_sql "select [1,2,3][-2:]"
    qt_sql "select [1,2,3][2:-1]"
    qt_sql "select [1,2,3][0:]"
    qt_sql "select [1,2,3][-5:]"
    qt_sql "select [true, false, false][2:]"
    qt_sql "select (array(cast ('2023-02-06 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))[1:2]"
    qt_sql "select (array(cast ('2023-02-06' as datev2), cast ('2023-02-05' as datev2)))[1:2]"

    // array_popfront function
    qt_sql "select array_popfront([1,2,3,4,5,6])"
    qt_sql "select array_popfront([])"
    qt_sql "select array_popfront(null)"
    qt_sql "select array_popfront([null,2,3,4,5])"
    qt_sql "select array_popfront([1,2,3,4,null])"
    qt_sql "select array_popfront(['1','2','3','4','5','6'])"
    qt_sql "select array_popfront([null,'2','3','4','5','6'])"
    qt_sql "select array_popfront(['1','2','3','4','5',null])"
    qt_sql "select array_popfront(array(cast ('2023-02-06' as datev2), cast ('2023-02-05' as datev2), cast ('2023-02-07' as datev2), cast ('2023-02-05' as datev2)))"
    qt_sql "select array_popfront(array(null, cast ('2023-02-06' as datev2), cast ('2023-02-05' as datev2), cast ('2023-02-07' as datev2), cast ('2023-02-05' as datev2)))"
    qt_sql "select array_popfront(array(cast ('2023-02-06 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3)), cast ('2023-02-07 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))"

    // array_join function 
    qt_sql "select array_join([1, 2, 3], '_')"
    qt_sql "select array_join(['1', '2', '3', null], '_')"
    qt_sql "select array_join([null, '1', '2', '3', null], '_')"
    qt_sql "select array_join(['', '2', '3'], '_')"
    qt_sql "select array_join(['1', '2', ''], '_')"
    qt_sql "select array_join(['1', '2', '', null], '_')"
    qt_sql "select array_join(['', '', '3'], '_')"
    qt_sql "select array_join(['1', '2', '', ''], '_')"
    qt_sql "select array_join([null, null, '1', '2', '', '', null], '_')"
    qt_sql "select array_join([null, null, 1, 2, '', '', null], '_', 'any')"
    qt_sql "select array_join([''], '_')"
    qt_sql "select array_join(['', ''], '_')"
    qt_sql "select array_with_constant(3, '_')"
    qt_sql "select array_with_constant(2, '1')"
    qt_sql "select array_with_constant(4, 1223)"
    qt_sql "select array_with_constant(8, null)"
    // array_compact function
    qt_sql "select array_compact([1, 2, 3, 3, null, null, 4, 4])"
    qt_sql "select array_compact([null, null, null])"
    qt_sql "select array_compact([1.2, 1.2, 3.4, 3.3, 2.1])"
    qt_sql "select array_compact(['a','b','c','c','d'])"
    qt_sql "select array_compact(['aaa','aaa','bbb','ccc','ccccc',null, null,'dddd'])"
    qt_sql "select array_compact(['2015-03-13','2015-03-13'])"
    qt_sql "select array_compact(array(cast ('2023-02-06 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3)), cast ('2023-02-07 22:07:34.999' as datetimev2(3)),cast ('2023-02-04 23:07:34.999' as datetimev2(3))))"
    qt_sql "select array_compact(array(cast ('2023-02-06' as datev2), cast ('2023-02-05' as datev2), cast ('2023-02-07' as datev2), cast ('2023-02-05' as datev2)))"

    // array_apply
    qt_sql """select array_apply([1000000, 1000001, 1000002], '=', 1000002)"""
    qt_sql """select array_apply([1.111, 2.222, 3.333], '>=', 2)"""
    qt_sql """select array_apply(cast(array("2020-01-02", "2022-01-03", "2021-01-01", "1996-04-17") as array<datetimev2>), ">", '2020-01-02')"""
    qt_sql """select array_apply(array(cast (24.99 as decimal(10,3)),cast (25.99 as decimal(10,3))), ">", '25')"""
    qt_sql """select array_apply(array(cast (24.99 as decimal(10,3)),cast (25.99 as decimal(10,3))), "!=", '25.99')"""

    qt_sql "select array_concat([1, 2, 3], [2, 3, 4], [8, 1, 2], [9])"
    qt_sql "select array_concat([12, 23], [25, null], [null], [66])"
    qt_sql "select array_concat([1.2, 1.8], [9.0, 2.2], [2.8])"
    qt_sql "select array_concat(['aaa', null], ['bbb', 'fff'], [null, 'ccc'])"
    qt_sql "select array_concat(null, [1, 2, 3], null)"
    qt_sql "select array_concat(array(cast (12.99 as decimal(10,3)), cast (34.99 as decimal(10,3))), array(cast (999.28 as decimal(10,3)), cast (123.99 as decimal(10,3))))"
    qt_sql "select array_concat(array(cast ('2023-03-05' as datev2), cast ('2023-03-04' as datev2)), array(cast ('2023-02-01' as datev2), cast ('2023-02-05' as datev2)))"
    qt_sql "select array_concat(array(cast ('2023-03-05 12:23:24.999' as datetimev2(3)),cast ('2023-03-05 15:23:23.997' as datetimev2(3))))"

    qt_sql "select array(8, null)"
    qt_sql "select array('a', 1, 2)"
    qt_sql "select array(null, null, null)"
    // abnormal test
    try {
        sql "select array_intersect([1, 2, 3, 1, 2, 3], '1[3, 2, 5]')"
    } catch (Exception ex) {
        assert("${ex}".contains("errCode = 2, detailMessage = No matching function with signature: array_intersect"))
    }
}

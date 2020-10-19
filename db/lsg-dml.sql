insert into T_BOOK_LEVEL(level_name, condition_factor, details)
VALUES('全新', 0.90, '非二手书籍，理书阁从出版社采购的未拆分新书');

insert into T_BOOK_LEVEL(level_name, condition_factor, details)
VALUES('优良', 0.60, '八九成新，有不明显的使用痕迹或瑕疵（扉页/衬页、可能存在少量文字或盖章）');

insert into T_BOOK_LEVEL(level_name, condition_factor, details)
VALUES('普通', 0.20, '有较明显的使用痕迹和折痕、标注、磨损等轻微瑕疵问题，但不影响正常阅读');

insert into T_BOOK_LEVEL(level_name, condition_factor, details)
VALUES('不合格', 0.00, '书籍品相瑕疵已影响下一位书友的使用和阅读，并且无法修复，会验收不通过，不予支付书费');
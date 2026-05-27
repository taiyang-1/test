# CSS 盒模型与常用指令速查

---

## 一、盒子模型（Box Model）

每个 HTML 元素都是一个矩形盒子，从外到内共 4 层：

```
┌──────────────────────────────────────┐
│           margin（外边距）             │  ← 盒子与盒子之间的距离
│   ┌──────────────────────────────┐   │
│   │       border（边框）          │   │  ← 边界线
│   │   ┌──────────────────────┐   │   │
│   │   │    padding（内边距）   │   │   │  ← 内容到边框的距离
│   │   │   ┌──────────────┐   │   │   │
│   │   │   │   content    │   │   │   │  ← 文字/图片本身
│   │   │   │(width×height)│   │   │   │
│   │   │   └──────────────┘   │   │   │
│   │   └──────────────────────┘   │   │
│   └──────────────────────────────┘   │
└──────────────────────────────────────┘
```

**速记：** margin = 外交距离，padding = 内政距离，border = 国界线。

### 1.1 margin（外边距）

元素与**其他元素**之间的距离，在盒子外面，背景色透不进来。

```css
margin: 10px;                   /* 四边都是 10px */
margin: 10px 20px;              /* 上下 10，左右 20 */
margin: 10px 20px 30px 40px;    /* 上 右 下 左（顺时针） */
margin: 0 auto;                 /* 水平居中（必须有宽度） */
margin-top: 10px;               /* 单独设一侧 */
margin-bottom: 20px;
```

> margin 上下会**合并**（两个相邻元素的 margin 取最大值，不叠加）。

### 1.2 padding（内边距）

内容与**边框**之间的距离，在盒子里面，会显示背景色。

```css
padding: 10px;                  /* 写法跟 margin 一样 */
padding: 10px 20px;
padding: 10px 20px 30px 40px;
padding-left: 15px;
```

### 1.3 border（边框）

三个值：**粗细 样式 颜色**，顺序随意。

```css
border: 1px solid #333;         /* 实线 */
border: 2px dashed red;         /* 虚线 */
border: 3px dotted blue;        /* 点线 */
border: none;                   /* 去掉边框 */

/* 单边边框（常用作分隔线） */
border-bottom: 2px solid #ccc;
border-left: 4px solid #2196F3; /* 左侧强调线 */

/* 圆角 */
border-radius: 8px;             /* 四角统一 */
border-radius: 50%;             /* 正圆形 */
border-radius: 8px 4px 0 0;     /* 左上 右上 右下 左下 */
```

### 1.4 盒子实际大小计算

**默认 `box-sizing: content-box`：**

```
实际宽度 = width + padding左+右 + border左+右
实际高度 = height + padding上+下 + border上+下
```

例子：`width: 200px; padding: 20px; border: 5px;`
→ 实际宽度 = 200 + 40 + 10 = **250px**

**`box-sizing: border-box`（推荐）：**

```css
* {
    box-sizing: border-box;
}
```

设置后 `width` 包含了 padding 和 border，200px 就是 200px，不会再往外撑。

---

## 二、块级 vs 行内 vs 行内块

| | block（块级） | inline（行内） | inline-block（行内块） |
|---|---|---|---|
| 代表标签 | div, p, h1~h6 | span, a, strong | —（手动设） |
| 换行 | 独占一行 | 不换行 | 不换行 |
| 可设宽高 | ✅ | ❌ | ✅ |
| margin 四边 | ✅ 都生效 | ❌ 只有左右生效 | ✅ 都生效 |
| padding 四边 | ✅ 都生效 | 左右生效，上下不占空间 | ✅ 都生效 |

---

## 三、常用 CSS 指令分类速查

### 3.1 居中

| 场景 | 代码 |
|------|------|
| 块级元素水平居中 | `margin: 0 auto;`（须设 width） |
| 文字/行内元素水平居中 | `text-align: center;` |
| 单行文字垂直居中 | `line-height` = 容器高度 |
| Flex 水平+垂直居中 | `display: flex; justify-content: center; align-items: center;` |

### 3.2 取消/重置默认样式

| 场景 | 代码 |
|------|------|
| 去掉列表圆点 | `list-style: none;` |
| 去掉链接下划线 | `text-decoration: none;` |
| 去掉按钮/输入框边框 | `border: none; outline: none;` |
| 清除内外边距 | `margin: 0; padding: 0;` |
| 去掉加粗 | `font-weight: normal;` |
| 去掉斜体 | `font-style: normal;` |

### 3.3 文字样式

```css
font-size: 16px;                /* 字号 */
font-family: 'Microsoft YaHei', sans-serif;  /* 字体 */
font-weight: bold;              /* 加粗：normal/bold/100~900 */
font-style: italic;             /* 斜体 */
color: #333;                    /* 文字颜色 */
line-height: 1.5;               /* 行高，推荐用倍数 */
letter-spacing: 2px;            /* 字间距 */
text-indent: 2em;               /* 首行缩进两个字符 */
text-align: left;               /* 对齐：left/center/right/justify */
text-decoration: underline;     /* 下划线 */
text-decoration: line-through;  /* 删除线 */
text-decoration: none;          /* 去掉线 */
```

### 3.4 背景

```css
background-color: #f5f5f5;      /* 背景色 */
background: #f5f5f5;            /* 简写（推荐） */
background-image: url('bg.jpg');/* 背景图 */
background-size: cover;         /* 铺满容器 */
background-position: center;    /* 居中显示 */
background-repeat: no-repeat;   /* 不平铺 */
```

### 3.5 显示与隐藏

```css
display: none;       /* 完全消失，不占空间 */
visibility: hidden;  /* 看不见，但占着位置 */
opacity: 0;          /* 透明，也占位置 */
opacity: 0.8;        /* 半透明（0=全透，1=不透） */
```

### 3.6 溢出处理

```css
overflow: hidden;    /* 超出裁掉 */
overflow: scroll;    /* 始终显示滚动条 */
overflow: auto;      /* 需要时才显示滚动条 */

/* 单行文字溢出变省略号（三个必须配合） */
white-space: nowrap;
overflow: hidden;
text-overflow: ellipsis;
```

### 3.7 鼠标样式

```css
cursor: pointer;     /* 手型（按钮常用） */
cursor: default;     /* 正常箭头 */
cursor: not-allowed; /* 禁止标志 */
```

### 3.8 阴影

```css
box-shadow: 0 2px 8px rgba(0,0,0,0.15);   /* 盒子阴影：X Y 模糊 颜色 */
text-shadow: 1px 1px 2px rgba(0,0,0,0.3); /* 文字阴影 */
```

### 3.9 Flex 布局常用组合

```css
/* 父容器 */
display: flex;
justify-content: space-between;  /* 两端对齐，中间均分 */
justify-content: center;         /* 水平居中 */
align-items: center;             /* 垂直居中 */
flex-wrap: wrap;                 /* 允许换行 */
gap: 20px;                       /* 子元素间距 */

/* 子元素 */
flex: 1;                         /* 等分剩余空间 */
```

### 3.10 定位常用

```css
position: relative;  /* 相对自身偏移，仍占位置 */
position: absolute;  /* 相对父级定位，脱离文档流 */
position: fixed;     /* 固定在屏幕上，不随滚动 */
position: sticky;    /* 滚动到临界点时吸附 */
top: 0; left: 0; right: 0; bottom: 0;
z-index: 10;         /* 层叠顺序，越大越靠前 */
```

### 3.11 过渡常用

```css
transition: all 0.3s ease;               /* 所有属性平滑过渡 */
transition: background 0.3s, transform 0.2s; /* 指定属性 */
```

---

## 四、几个现成组合

```css
/* 导航栏横排 */
.nav {
    list-style: none;       /* 去圆点 */
    padding: 0; margin: 0;  /* 清间距 */
    display: flex; gap: 20px;
}

/* 链接 */
a { text-decoration: none; color: #2196F3; }
a:hover { text-decoration: underline; color: #1565c0; }

/* 卡片 */
.card {
    width: 300px;
    padding: 20px;
    margin: 0 auto;               /* 水平居中 */
    border: 1px solid #ddd;
    border-radius: 8px;
    box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    background: #fff;
}

/* 图片圆形 */
.avatar {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    border: 2px solid #ddd;
    object-fit: cover;            /* 图片不变形地裁切填充 */
}

/* 按钮 */
.btn {
    display: inline-block;
    padding: 8px 20px;
    border: none;
    border-radius: 4px;
    background: #2196F3;
    color: #fff;
    cursor: pointer;
    text-align: center;
}
.btn:hover { background: #1565c0; }
```

---

> 盒模型 + Flex + 居中/去格式/颜色/边框，这六样搞熟了就能应付 80% 的日常 CSS 工作。

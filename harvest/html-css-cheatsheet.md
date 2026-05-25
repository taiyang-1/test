# HTML + CSS 常用速查手册

---

## 一、HTML 常用标签

### 文档结构

| 标签 | 作用 | 常用属性 |
|------|------|---------|
| `<!DOCTYPE html>` | 声明 HTML5 文档类型 | — |
| `<html>` | 根元素 | `lang="zh-CN"` |
| `<head>` | 文档头部（不显示在页面） | — |
| `<meta>` | 元信息 | `charset="UTF-8"` / `name="viewport" content="width=device-width"` |
| `<title>` | 浏览器标签页标题 | — |
| `<link>` | 引入外部资源 | `rel="stylesheet" href="style.css"` |
| `<script>` | 引入 JS | `src="app.js"` / `defer` |
| `<body>` | 页面可见内容 | — |

---

### 文本标签

| 标签 | 作用 | 说明 |
|------|------|------|
| `<h1>` ~ `<h6>` | 标题，h1 最大 | 一个页面只用一个 h1 |
| `<p>` | 段落 | 块级，上下有间距 |
| `<span>` | 行内容器 | 无语义，用于局部样式 |
| `<div>` | 块级容器 | 无语义，用于布局分组 |
| `<strong>` | 重要内容（加粗） | 有语义，搜索引擎识别 |
| `<em>` | 强调（斜体） | 有语义 |
| `<br>` | 换行（自闭合） | — |
| `<hr>` | 水平分隔线（自闭合） | — |
| `<mark>` | 高亮文字 | 默认黄色背景 |
| `<del>` | 删除线 | 表示已删除内容 |

---

### 链接与图片

| 标签 | 作用 | 常用属性 |
|------|------|---------|
| `<a>` | 超链接 | `href="url"` 目标地址<br>`target="_blank"` 新窗口打开<br>`target="_self"` 当前窗口（默认）<br>`href="#id"` 页面内锚点跳转 |
| `<img>` | 图片（自闭合） | `src="路径"` 图片地址<br>`alt="描述"` 加载失败时显示<br>`width` / `height` 宽高 |

---

### 列表

| 标签 | 作用 | 说明 |
|------|------|------|
| `<ul>` | 无序列表 | 子元素必须是 `<li>` |
| `<ol>` | 有序列表 | 子元素必须是 `<li>`，自动编号 |
| `<li>` | 列表项 | 放在 ul 或 ol 内 |

---

### 表格

| 标签 | 作用 |
|------|------|
| `<table>` | 表格容器，属性：`border` `cellpadding` `cellspacing` |
| `<thead>` | 表头区域 |
| `<tbody>` | 表体区域 |
| `<tr>` | 行 |
| `<th>` | 表头单元格（加粗居中） |
| `<td>` | 普通单元格，`colspan="2"` 横向合并，`rowspan="2"` 纵向合并 |

---

### 表单

| 标签 | 作用 | 常用属性 |
|------|------|---------|
| `<form>` | 表单容器 | `action="提交地址"` `method="get/post"` |
| `<input>` | 输入框（自闭合） | `type` 见下表<br>`name` 字段名<br>`placeholder` 提示文字<br>`value` 默认值<br>`required` 必填 |
| `<label>` | 输入框标签 | `for="input的id"` 点击标签聚焦输入框 |
| `<textarea>` | 多行文本 | `rows` `cols` `placeholder` |
| `<select>` | 下拉选择 | `name` |
| `<option>` | 下拉选项 | `value` `selected`（默认选中） |
| `<button>` | 按钮 | `type="submit"` 提交 / `type="reset"` 重置 / `type="button"` 普通 |

**input type 常用值：**

| type | 效果 |
|------|------|
| `text` | 普通文本 |
| `password` | 密码（隐藏字符） |
| `email` | 邮箱（有格式校验） |
| `number` | 数字 |
| `radio` | 单选框（同组 name 相同） |
| `checkbox` | 复选框 |
| `file` | 文件上传 |
| `date` | 日期选择器 |
| `range` | 滑块 |
| `hidden` | 隐藏字段 |

---

### 语义化标签（HTML5）

| 标签 | 作用 |
|------|------|
| `<header>` | 页头 / 区块头部 |
| `<nav>` | 导航区域 |
| `<main>` | 页面主体（每页只有一个） |
| `<section>` | 内容区块（有主题的分组） |
| `<article>` | 独立内容（博客文章、评论） |
| `<aside>` | 侧边栏 / 附加信息 |
| `<footer>` | 页脚 / 区块底部 |

---

## 二、CSS 常用属性

### 引入方式

```html
<!-- 外部（推荐） -->
<link rel="stylesheet" href="style.css">

<!-- 内部 -->
<style> p { color: red; } </style>

<!-- 内联（优先级最高，不推荐大量使用） -->
<p style="color: red;">文字</p>
```

---

### 选择器

| 选择器 | 写法 | 说明 |
|--------|------|------|
| 元素 | `p {}` | 选中所有 p 标签 |
| 类 | `.box {}` | 选中 class="box" 的元素 |
| ID | `#title {}` | 选中 id="title" 的元素 |
| 后代 | `.nav a {}` | .nav 内所有 a（不限层级） |
| 子代 | `.nav > a {}` | .nav 直接子元素 a |
| 伪类 | `a:hover {}` | 鼠标悬停时 |
| 伪类 | `li:first-child {}` | 第一个子元素 |
| 伪类 | `li:nth-child(2) {}` | 第 n 个子元素 |
| 伪元素 | `p::before {}` | 在 p 内容前插入 |
| 伪元素 | `p::after {}` | 在 p 内容后插入 |
| 通配符 | `* {}` | 选中所有元素 |

**优先级（从高到低）：** `!important` > 内联 > `#id` > `.class` > 元素

---

### 颜色与单位

```css
/* 颜色写法 */
color: red;              /* 颜色名 */
color: #ff0000;          /* 十六进制 */
color: rgb(255, 0, 0);   /* RGB */
color: rgba(255,0,0,0.5);/* RGBA，最后一位是透明度 0~1 */

/* 单位 */
px   /* 像素，固定大小 */
%    /* 相对父元素的百分比 */
em   /* 相对当前元素字体大小（1em = 当前字号） */
rem  /* 相对根元素(html)字体大小，更好控制 */
vw   /* 视口宽度的 1%（100vw = 整个屏幕宽） */
vh   /* 视口高度的 1% */
```

---

### 字体与文本

```css
font-family: 'Microsoft YaHei', Arial, sans-serif; /* 字体，逗号隔开备选 */
font-size: 16px;          /* 字号 */
font-weight: bold;        /* 粗细：normal / bold / 100~900 */
font-style: italic;       /* 斜体 */
line-height: 1.6;         /* 行高，推荐用无单位倍数 */
text-align: center;       /* 对齐：left / center / right / justify */
text-decoration: none;    /* 装饰：none / underline / line-through */
text-indent: 2em;         /* 首行缩进 */
letter-spacing: 2px;      /* 字间距 */
color: #333;              /* 文字颜色 */
```

---

### 盒模型

```css
/* 每个元素都是一个盒子：content + padding + border + margin */

width: 200px;
height: 100px;
padding: 10px;            /* 内边距（内容到边框的距离） */
padding: 10px 20px;       /* 上下 10px，左右 20px */
padding: 10px 20px 15px 5px; /* 上 右 下 左（顺时针） */
border: 1px solid #ccc;   /* 边框：宽度 样式 颜色 */
border-radius: 8px;       /* 圆角 */
margin: 20px auto;        /* 外边距，auto 可水平居中块级元素 */

/* 重要：推荐全局设置，让 width 包含 padding 和 border */
box-sizing: border-box;
```

---

### 背景

```css
background-color: #f0f0f0;
background-image: url('bg.jpg');
background-size: cover;       /* cover 铺满 / contain 完整显示 */
background-position: center;  /* 位置 */
background-repeat: no-repeat; /* 不重复 */

/* 线性渐变 */
background: linear-gradient(135deg, #667eea, #764ba2);
```

---

### display 与可见性

```css
display: block;        /* 块级：独占一行，可设宽高 */
display: inline;       /* 行内：不换行，宽高无效 */
display: inline-block; /* 行内块：不换行，但可设宽高 */
display: none;         /* 隐藏，不占位 */
visibility: hidden;    /* 隐藏，但仍占位 */
```

---

### 定位 position

```css
position: static;    /* 默认，正常文档流 */
position: relative;  /* 相对自身原位置偏移，仍占位 */
position: absolute;  /* 相对最近的非 static 父元素定位，脱离文档流 */
position: fixed;     /* 相对浏览器窗口固定，不随滚动移动 */
position: sticky;    /* 滚动到指定位置后固定（如吸顶导航） */

/* 配合使用 */
top: 10px;
right: 10px;
bottom: 10px;
left: 10px;
z-index: 10;  /* 层叠顺序，数值越大越靠前 */
```

---

### Flexbox 弹性布局

```css
/* 父容器 */
display: flex;
flex-direction: row;          /* 主轴方向：row(横) / column(竖) */
justify-content: space-between; /* 主轴对齐：flex-start/center/flex-end/space-between/space-around */
align-items: center;          /* 交叉轴对齐：flex-start/center/flex-end/stretch */
flex-wrap: wrap;              /* 换行：nowrap(默认) / wrap */
gap: 16px;                    /* 子元素间距 */

/* 子元素 */
flex: 1;        /* 等比例占满剩余空间 */
flex-grow: 1;   /* 放大比例 */
flex-shrink: 0; /* 不缩小 */
align-self: center; /* 单独设置该子元素的交叉轴对齐 */
```

---

### Grid 网格布局

```css
/* 父容器 */
display: grid;
grid-template-columns: 1fr 1fr 1fr;   /* 三列等宽 */
grid-template-columns: repeat(3, 1fr); /* 同上，简写 */
grid-template-columns: 200px auto 1fr; /* 混合宽度 */
grid-template-rows: 100px auto;        /* 行高 */
gap: 16px;                             /* 间距 */

/* 子元素跨格 */
grid-column: 1 / 3;  /* 从第1列线到第3列线（占2列） */
grid-row: 1 / 2;
```

---

### 过渡与动画

```css
/* 过渡：属性变化时平滑过渡 */
transition: all 0.3s ease;
transition: background-color 0.3s ease, transform 0.2s;

/* 变换 */
transform: translateX(10px);   /* 水平移动 */
transform: translateY(-5px);   /* 垂直移动 */
transform: scale(1.1);         /* 放大 1.1 倍 */
transform: rotate(45deg);      /* 旋转 45 度 */

/* 动画 */
@keyframes fadeIn {
  from { opacity: 0; transform: translateY(20px); }
  to   { opacity: 1; transform: translateY(0); }
}

.box {
  animation: fadeIn 0.5s ease forwards;
  animation-delay: 0.2s;       /* 延迟 */
  animation-iteration-count: infinite; /* 无限循环 */
}
```

---

### CSS 变量

```css
/* 定义（通常放在 :root 全局生效） */
:root {
  --primary: #667eea;
  --text: #333;
  --radius: 8px;
}

/* 使用 */
.btn {
  background: var(--primary);
  border-radius: var(--radius);
}
```

---

### 响应式 @media

```css
/* 移动优先：先写小屏样式，再用 min-width 覆盖大屏 */
.container { width: 100%; }

@media (min-width: 768px) {
  .container { width: 750px; }
}

@media (min-width: 1200px) {
  .container { width: 1140px; }
}

/* 常用断点 */
/* 手机：< 768px */
/* 平板：768px ~ 1024px */
/* 桌面：> 1024px */
```

---

### 常用工具属性

```css
/* 溢出处理 */
overflow: hidden;    /* 超出隐藏 */
overflow: scroll;    /* 显示滚动条 */
overflow: auto;      /* 超出时才显示滚动条 */

/* 文字溢出省略号（需配合使用） */
white-space: nowrap;
overflow: hidden;
text-overflow: ellipsis;

/* 鼠标样式 */
cursor: pointer;   /* 手型 */
cursor: default;   /* 默认箭头 */

/* 阴影 */
box-shadow: 0 4px 12px rgba(0,0,0,0.15);   /* 盒阴影 */
text-shadow: 1px 1px 2px rgba(0,0,0,0.3);  /* 文字阴影 */

/* 透明度 */
opacity: 0.8;  /* 0 完全透明，1 完全不透明 */
```

---

> 记住：`div` + `span` + `p` + `a` + `img` + `input` 这 6 个 HTML 标签能写出大部分页面结构；`flex` + `position` + `盒模型` 是 CSS 布局的核心。

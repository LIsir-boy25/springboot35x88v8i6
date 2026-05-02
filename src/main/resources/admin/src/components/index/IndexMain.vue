<template>
	<div style="height: 100%;">
		<el-main :style='"vertical" == "vertical" ? (2 == 1 ? {"minHeight":"100%","padding":"0","margin":"0 0 0 371px","position":"relative","display":"block"} : (2 == 2 ? (isCollapse ? {"minHeight":"100%","padding":"0 0 0 250px","margin":"0","position":"relative","background":"linear-gradient( 132deg, #B4CBFF 0%, #C3D5FB 20%, #D5ECF5 32%, #D9E3FB 42%, #CCEBFD 60%, #CBEAFC 77%, #D4E1FD 87%, #CEE6FD 100%)","display":"block"} : {"minHeight":"100%","padding":"0","margin":"0 0 0 260px","position":"relative","background":"linear-gradient( 132deg, #B4CBFF 0%, #C3D5FB 20%, #D5ECF5 32%, #D9E3FB 42%, #CCEBFD 60%, #CBEAFC 77%, #D4E1FD 87%, #CEE6FD 100%)","display":"block"}) : "")) : {"minHeight":"100%","margin":"0","position":"relative"}'>
			<!-- top -->
			<index-header :style='{"padding":"0px 30px 0 0","margin":"0","alignItems":"center","display":"flex","justifyContent":"flex-end","top":"0","flexWrap":"wrap","left":"0","background":"linear-gradient( 132deg, #B4CBFF 0%, #C3D5FB 20%, #D5ECF5 32%, #D9E3FB 42%, #CCEBFD 60%, #CBEAFC 77%, #D4E1FD 87%, #CEE6FD 100%)","width":"calc(100% - 0px)","position":"fixed","zIndex":"222","height":"84px"}'></index-header>
			
			<!-- menu -->
			<template v-if="'vertical' == 'vertical'">
			  <template v-if="2 == 1">
				<index-aside :style='{"boxShadow":"1px 0 6px  rgba(64, 158, 255, .3)","overflow":"hidden","top":"0","left":"0","background":"url(http://codegen.caihongy.cn/20250918/325efc3c35b1418eace374c6024c311e.png) no-repeat  center  center / 100% 100%","bottom":"0","width":"371px","fontSize":"0px","position":"fixed","height":"100%","zIndex":"1001"}'></index-aside>
			  </template>
			  <template v-if="2 == 2">
				<index-aside :is-collapse="isCollapse" @oncollapsechange="collapseChange" :style='isCollapse ? {"boxShadow":"1px 0 0px  #e7e8fc","padding":"110px  0 60px 0","overflow":"hidden","top":"0","left":"0","background":"url(http://codegen.caihongy.cn/20250918/325efc3c35b1418eace374c6024c311e.png) no-repeat  center  center / 100% 100%","bottom":"0","width":"250px","position":"fixed","transition":"all 0s","height":"100%","zIndex":"1001"} : {"padding":"80px 0 0 0","overflow":"hidden","top":"84px","left":"0","background":"url(http://codegen.caihongy.cn/20250918/325efc3c35b1418eace374c6024c311e.png) no-repeat center -80px / 100% 100%","bottom":"0","width":"260px","position":"fixed","transition":"width 0.3s","height":"100%","zIndex":"1001"}'></index-aside>
			  </template>
			</template>
			<template v-if="'vertical' == 'horizontal'">
			  <template v-if="2 == 1">
				<index-aside :style='{"width":"100%","borderColor":"#efefef","borderStyle":"solid","background":"#304156","borderWidth":"0 0 1px 0","height":"auto"}'></index-aside>
			  </template>
			  <template v-if="2 == 2">
				<index-aside :style='{"borderColor":"#efefef","background":"#FFF","borderWidth":"0 0 1px 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'></index-aside>
			  </template>
			</template>
			
			<!-- breadcrumb -->
			<bread-crumbs :title="title" :style='{"width":"calc(100% - 10px)","padding":"94px 10px 10px 30px","boxShadow":"0 0px 0px #055bab","margin":"0","borderRadius":"0px","background":"none"}' class="bread-crumbs"></bread-crumbs>
			
			<!-- TagsView -->
			<tags-view />
			<router-view class="router-view"></router-view>
		</el-main>
	</div>
</template>

<script>
	import IndexAside from '@/components/index/IndexAsideStatic'
	import IndexHeader from '@/components/index/IndexHeader'
	import TagsView from '@/components/index/TagsView'
	import menu from "@/utils/menu";
	export default {
		components: {
			IndexAside,
			IndexHeader,
			TagsView
		},
		data() {
			return {
				menuList: [],
				role: "",
				currentIndex: -2,
				itemMenu: [],
				title: '',
				isCollapse: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menuList = menus;
			this.role = this.$storage.get("role");
		},
		created() {
			this.init();
		},
		methods: {
			init(){
				this.$nextTick(()=>{
					
				})
			},
			collapseChange(collapse) {
				this.isCollapse = collapse
			},
			menuHandler(menu) {
				this.$router.push({
					name: menu.tableName
				});
				this.title = menu.menu;
			},
			titleChange(index, menus) {
				this.currentIndex = index
				this.itemMenu = menus;
			},
			homeChange(index) {
				this.itemMenu = [];
				this.title = ""
				this.currentIndex = index
				this.$router.push({
					name: 'home'
				});
			},
			centerChange(index) {
				this.itemMenu = [{
					"buttons": ["新增", "查看", "修改", "删除"],
					"menu": "修改密码",
					"tableName": "updatePassword"
				}, {
					"buttons": ["新增", "查看", "修改", "删除"],
					"menu": "个人信息",
					"tableName": "center"
				}];
				this.title = ""
				this.currentIndex = index
				this.$router.push({
					name: 'home'
				});
				
			}
		}
	};
</script>
<style lang="scss" scoped>
	a {
		text-decoration: none;
		color: #555;
	}

	a:hover {
		background: #00c292;
	}
	
	.el-main {
		padding: 0;
		display: block;
	}

	.nav-list {
		width: 100%;
		margin: 0 auto;
		text-align: left;
		margin-top: 20px;

		.nav-title {
			display: inline-block;
			font-size: 15px;
			color: #333;
			padding: 15px 25px;
			border: none;
		}

		.nav-title.active {
			color: #555;
			cursor: default;
			background-color: #fff;
		}
	}

	.nav-item {
		margin-top: 20px;
		background: #FFFFFF;
		padding: 15px 0;

		.menu {
			padding: 15px 25px;
		}
	}
	
	.detail-form-content {
	    background: transparent;
	}
</style>

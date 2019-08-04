<template>
    <v-navigation-drawer class="mt-4 ma-2 elevation-6" v-model="$store.state.drawer" :clipped="true" width="256" :color="$store.state.color" app>
        <v-list dense rounded>
            <template v-for="item in items">
                <v-list-group v-if="item.children" :key="item.text" v-model="item.model" :prepend-icon="item.model ? item.icon : item['icon-alt']" append-icon="">
                    <template v-slot:activator>
                        <v-list-item>
                            <v-list-item-content>
                                <v-list-item-title>
                                    {{ item.text }}
                                </v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </template>
                    <v-list-item v-for="(child, i) in item.children" :key="i" @click="toPage(child.path)">
                        <v-list-item-action v-if="child.icon">
                            <v-icon>{{ child.icon }}</v-icon>
                        </v-list-item-action>
                        <v-list-item-content>
                            <v-list-item-title>
                                {{ child.text }}
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list-group>
                <v-list-item v-else :key="item.text" @click="toPage(item.path)">
                    <v-list-item-action>
                        <v-icon>{{ item.icon }}</v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title>
                            {{ item.text }}
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </template>
        </v-list>
    </v-navigation-drawer>
</template>
<script>
export default {
    props: {},
    data: () => ({
        items: [{
            icon: 'keyboard_arrow_up',
            'icon-alt': 'keyboard_arrow_down',
            text: '用户模块',
            model: false,
            children: [
            { icon: 'person', text: '用户管理', path: '/memberUser' },
            { icon: 'add', text: '角色管理', path: '/memberRole' },
            { icon: 'person', text: '资源管理', path: '/memberResource' },
            { icon: 'add', text: '权限管理', path: '/memberAuthority' },
            ],
        }, { icon: 'content_copy', text: '关于网站', path: '/' }, ],
    }),
    methods: {
        toPage(path) {
            this.$router.push(path);
        }
    }
}
</script>